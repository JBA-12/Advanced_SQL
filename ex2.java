package net.javaguides.postgresql;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class ex2 {
   private final String url = "jdbc:postgresql://localhost/univdb";
   private final String user = "postgres";
   private final String password = "dbms";
   
   private void connect() {
	   try(Connection connection = DriverManager.getConnection(url, user, password);){
		   if(connection != null) {
			   System.out.println("Connected");
		   }else {
			   System.out.println("Failed"); 
		   }
		   
		   Scanner sc = new Scanner(System.in);
		       System.out.print("course id: ");
			   String name = sc.next();	   
			   
			   Statement statement = connection.createStatement();
		       ResultSet rs = statement.executeQuery("with recursive rec_prereq(course_id, prereq_id) as (\r\n"
			   		                                      + "select course_id, prereq_id\r\n"
			   		                                      + "from prereq\r\n"
			   		                                      + "union\r\n"
			   		                                        + "select rec_prereq.course_id, prereq.prereq_id\r\n"
     		   		                                        + "from rec_prereq, prereq\r\n"
			   		                                        + "where rec_prereq.prereq_id = prereq.course_id\r\n"
			   		                                        + ")\r\n"
                                                            + "select prereq_id, title\r\n"
			   		                                        + "from course,rec_prereq\r\n"
			   		                                        + "where rec_prereq.prereq_id = course.course_id\r\n"
															+ "and rec_prereq.prereq_id <> rec_prereq.course_id\r\n"
			   		                                        + "and rec_prereq.course_id =\r\n"+name);
			   		                                        
					                                       
			   
			   ResultSetMetaData rsmd = rs.getMetaData();
			   int columnCount = rsmd.getColumnCount();
			   while (rs.next()) {
				    for (int i = 1; i <= columnCount; i++) {
				        if (i > 1) System.out.print(" ");
				        String columnValue = rs.getString(i);
				        System.out.print(columnValue);
				    }
				    System.out.println("");
			   }
	   	  
		    
		   
	   } catch (SQLException e) {
		       e.printStackTrace();
	         }
   }
   
   

   public static void main(String[] args) {
	   JDBC sqlConnect = new JDBC();
	   sqlConnect.connect();
	   
	  
   }
}
