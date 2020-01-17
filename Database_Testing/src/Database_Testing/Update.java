package Database_Testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.mysql.jdbc.PreparedStatement;

public class Update {
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
		public void Update(){
			try{
				String query="update emp_details set FIRST_Name=? where id=?";
				java.sql.PreparedStatement pstmt;
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1, "abhi");
				pstmt.setInt(2, 1);
				pstmt.executeUpdate();
				System.out.println("successfully updated");
				
			}
			catch(SQLException e){
				//TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Unable to update");
			}
			}
			@Test(priority=2)
			public void Read(){
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

