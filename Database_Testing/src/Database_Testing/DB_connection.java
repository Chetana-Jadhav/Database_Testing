package Database_Testing;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class DB_connection {
    Connection conn=null;
	// database url
	String DbURl = "jdbc:mysql://localhost:3306/"; // object of java db : db type ://(protocol localhost:port number
	String uname ="root"; // db username
	String pass =""; // db password
	@Test
	public void Connection(){	
		try
		{	
			Class.forName("com.mysql.jdbc.Driver"); 
			conn = DriverManager.getConnection(DbURl,uname,pass);
			System.out.println("Successfully Connected!!!!");
		}
		catch(Exception e)
		{ 	System.out.println("Connection Failed...");
		e.printStackTrace();
		}
	}
	@AfterTest
	public void tearDown() throws SQLException {	
		if (conn != null)
		{	
			conn.close();
		}
	}
}
