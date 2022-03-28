package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Selectquery_SampleCode {
public static void main(String[] args) throws SQLException {
	 Connection conn = null;
	 
	 try {
	// load/register the database
	 Driver driverRef = new Driver();
	 DriverManager.registerDriver(driverRef);
	 
	 // connect to database
	 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
	 System.out.println("connection is done");
	 //create query statement
	  Statement stat = conn.createStatement();
	  String query = "select * from project";
	 
	  //execute query
	 ResultSet  resultset = stat.executeQuery(query);
	  while(resultset.next())
	  {
		  System.out.println(resultset.getString(1) +"\t" +resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4));
		  
	  }
	 }
	 catch(Exception e)
	 {
		 
	 }
	  
	  finally
	  {
		 
		  //close the connection
		  conn.close();
		  
		  System.out.println("close db connection");
	  }
	 
	  
}
}
