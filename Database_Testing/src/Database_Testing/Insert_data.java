package Database_Testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.mysql.jdbc.PreparedStatement;

public class Insert_data {
	Connection conn=null;
	java.sql.Statement stmt=null;
	PreparedStatement pstmt=null;
	java.sql.ResultSet resultset=null;
	String DbURl = "jdbc:mysql://localhost:3306/company"; // object of java db : db type ://(protocol localhost:port number
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
		@Test(priority=1)
		public void Insert(){
			try{
				//the mysql insert statement
				String query ="insert into emp_details(id,FIRST_Name,LAST_NAME,SALARY)"
						+"values(?,?,?,?)";
				java.sql.PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setInt(1,2);
				pstmt.setString(2,"pqr");
				pstmt.setString(3,"pqr");
				//pstmt.setString(4,"pqr@pqr.com");
				pstmt.setDouble(4,2000);
				//execute the prepareStatement
				pstmt.execute();
				System.out.println("successfully INSERTED");
			}
			catch(SQLException e){
				//TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Unable to INSERT");
			}
		
		}
		@Test(priority=2)
		public void verifyData(){
			//Execute query
			try{
				stmt = conn.createStatement();
				resultset = stmt.executeQuery("select *from emp_details");
				while(resultset.next()){
					System.out.println("....................");
					System.out.println(resultset.getString(1)+"|"+resultset.getString(2)+"|"+resultset.getString(3)+"|"+resultset.getString(4)+"\n");
				}

			}
		
		catch(SQLException e){
			//TODO Auto-generated catch block
			e.printStackTrace();

		}
		}
}

