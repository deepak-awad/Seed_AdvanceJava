package Day1;
import java.sql.*;

public class JDBCConnection1 {

	public static void main(String[] args) {
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Seed","Seed123");
			
			Statement stmt  = conn.createStatement();
			
			String sql = "insert into Employee values(1,'Deepak Awad',25000)";
			
			int result  = stmt.executeUpdate(sql);
			
	            if (result > 0) 
	                System.out.println("successfully inserted");
	  
	            else
	                System.out.println( 
	                    "unsucessful insertion "); 
			
	
			
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}


	}

}
