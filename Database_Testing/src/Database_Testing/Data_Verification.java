package Database_Testing;

import org.testng.annotations.Test;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.AfterTest;

public class Data_Verification {
	Connection conn=null;
	java.sql.Statement stmt=null;
	java.sql.ResultSet resultset=null;
	String DbURl = "jdbc:mysql://localhost:3306/hospital"; // object of java db : db type ://(protocol localhost:port number
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
	@Test
	public void verifyData(){
		//Execute query
		try{
			stmt = conn.createStatement();
			resultset = stmt.executeQuery("select *from admin");
			while(resultset.next()){
				System.out.println("....................");
				System.out.println(resultset.getString(1)+"|"+resultset.getString(2)+"|"+resultset.getString(3)+"|"+resultset.getString(4)+"|"+resultset.getString(5)+"|"+resultset.getString(6)+"\n");
			}

		}
		catch(SQLException e){
			//TODO Auto-generated catch block
			e.printStackTrace();

		}
	}


	@AfterTest
	public void afterTest() {
	}

}
