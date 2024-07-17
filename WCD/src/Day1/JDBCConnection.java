package Day1;
import java.sql.*;

public class JDBCConnection {
	
	public static void main(String[] args) 
	 {
		
	   try
	   {
		 //step 1 : load the driver 
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 //step 2 : Create the connection
		 Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","Seed","Seed123");
		 //step3: create SQL query
		 String sql="select * from Employee";
		//step4: Associate the SQL query with connection object
		 Statement stmt=con.createStatement();
		 //step 5:Get the result
		 ResultSet rs=stmt.executeQuery(sql);
		 //step 6: process the result
		 System.out.println("Employees are:");
		 while(rs.next())
		 {
			 System.out.println(""+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		 }
		 con.close();	 
	   }
	   catch(SQLException e)
	   {
		   e.printStackTrace();
	   }
	   catch(ClassNotFoundException e)
	   {
		   e.printStackTrace();
	   }//end catch
	   
	 }//end main
	
}
