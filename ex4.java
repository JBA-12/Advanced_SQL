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

public class ex4 {
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
		       System.out.print("roll no: ");
			   String name = sc.next();		   
			   
			   Statement statement = connection.createStatement();
			   		 
			   ResultSet rs = statement.executeQuery("select op from output where output.id = \r\n"+name);
			   		
                           
					                                       
			   
			   ResultSetMetaData rsmd = rs.getMetaData();
			   int columnCount = rsmd.getColumnCount();
			   while (rs.next()) {
				    for (int i = 1; i <= columnCount; i++) {
				        if (i > 1) System.out.print(" ");
				        String columnValue = rs.getString(i);
				        if (rs.wasNull()) {
				        	System.out.print("roll no does not exist");
				        }
				        else System.out.print(columnValue);
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
