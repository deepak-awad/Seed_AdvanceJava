package Day2;
import java.sql.*;
import java.util.Scanner;

public class TransactionExample {
	
	public static void main(String args[]) throws SQLException
	{
		Connection conn = null;
		try
		{
			Scanner sc = new Scanner(System.in);
			
			
			//Connection Implement
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","Seed","Seed123");
			conn.setAutoCommit(false);
			//Step 2: find the employee is present or not
			System.out.println("Enter the employee id:");
			int id  = sc.nextInt();
			
            PreparedStatement ps = conn.prepareStatement("Select * from Employee where EmpId= ?");
            
			ps.setInt(1, id);
			
			ResultSet rs  = ps.executeQuery();
			
			while(rs.next())
			{
				System.out.println("The user is find");
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
			
			//Step 3: To withdraw amount form account
			System.out.println("Enter the employee amount to withdraw:");
			int amount  = sc.nextInt();
			
			PreparedStatement ps1 = conn.prepareStatement("Update Employee set Salary = salary - ? where EmpId = ?");
			
			ps1.setInt(1, amount);
			ps1.setInt(2, id);
			
			int check = ps1.executeUpdate();
			if(check > 0)
			{
				System.out.println("Data Updated Successfulluy");
			}else
			{
				System.out.println("Data is not updated Sucessfully");
			}
			
			//step 4: find the receiver employee is present or not
			System.out.println("Enter the employee id:");
			int receiverid  = sc.nextInt();
			
            PreparedStatement ps3 = conn.prepareStatement("Select * from Employee where EmpId= ?");
            
			ps.setInt(1, receiverid);
			
			ResultSet rs3  = ps3.executeQuery();
			
			while(rs3.next())
			{
				System.out.println("The user is find");
				System.out.println(rs3.getInt(1)+" "+rs3.getString(2)+" "+rs3.getInt(3));
			}
			
			//Step 5: To deposit amount to account
           PreparedStatement ps4 = conn.prepareStatement("Update Employee set Salary = salary + ? where EmpId = ?");
			
			ps4.setInt(1, amount);
			ps4.setInt(2, receiverid);
			
			int check1 = ps4.executeUpdate();
			if(check1 > 0)
			{
				System.out.println("Data Deposit Successfulluy");
			}else
			{
				System.out.println("Data not Deposited");
			}
		
			conn.commit();
			
			
		}catch(ClassNotFoundException e)
		{
			conn.rollback(); 
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
