package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Sample_sql {
 public static void main(String[] args) throws SQLException {
	 Connection conn = null;
	 int result=0;
	 try {
	// load/register the database
	 Driver driverRef = new Driver();
	 DriverManager.registerDriver(driverRef);
	 
	 // connect to database
	 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
	 
	 //create query statement
	  Statement stat = conn.createStatement();
	  String query = "insert into students_info values('8','deepak','gowda','h');";
	 
	  //execute query
	  result = stat.executeUpdate(query);
	 }
	 catch(Exception e)
	 {
		 
	 }
	  
	  finally
	  {
		  if(result==1)
		  {
			  System.out.println("project inserted successfully");
		  }
		  else
		  {
			  System.out.println("project is not inserted");
		  }
		  //close the connection
		  conn.close();
		  
		  
	  }
	 
	  
	 
}
}
 