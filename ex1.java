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

public class ex1 {
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
		       System.out.print("Table name: ");
			   String name = sc.next();
			   System.out.print("No of rows: ");
			   int k = sc.nextInt();
		   
			   
			   Statement statement = connection.createStatement();
			   ResultSet resultSet = statement.executeQuery("SELECT * from "+name);
					                                       //+ "limit "+k);
					                                       
			   ResultSetMetaData rsmd = resultSet.getMetaData();
			   int columnCount = rsmd.getColumnCount();
			   for (int i = 1; i <= columnCount; i++) {
			   System.out.print(rsmd.getColumnName(i)+" ");
			   }
			   System.out.println("");
			   int limit = 0;
			   while (resultSet.next() && limit<k) {
				    for (int i = 1; i <= columnCount; i++) {
				        if (i > 1) System.out.print(" ");
				        String columnValue = resultSet.getString(i);
				        System.out.print(columnValue);
				    }
				    System.out.println("");
				    limit = limit+1;
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

