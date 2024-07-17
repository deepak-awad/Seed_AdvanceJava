package Day1;
import java.sql.*;
import java.util.Scanner;

public class JDBCConnection3 {
	
	public static void main(String args[])
	{
		 Scanner sc = new Scanner(System.in);
	        int id;

	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");

	            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Seed", "Seed123");

	            System.out.println("Enter id");
	            id = sc.nextInt();

	            String sql = "Delete from Employee where EmpId = ?";
	            PreparedStatement ps = conn.prepareStatement(sql);

	            ps.setInt(1, id);
	            
	            if( ps.executeUpdate() != 0)
	            {

	            System.out.println("Data deleted successfully.");
	            }else
	            {

		            System.out.println("Data not deleted successfully.");
	            }
	            
	            ps.close();
	            conn.close();
	            sc.close();

	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
