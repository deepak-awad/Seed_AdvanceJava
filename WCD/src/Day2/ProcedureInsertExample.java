package Day2;
import java.util.Scanner;
import java.sql.*;

/*** Procedure example with insert statement
 * 
 * with procedure
 * 
 * CREATE OR REPLACE PROCEDURE INSERTEMPLOYEE(ID IN NUMBER, NAME IN VARCHAR, SALARY IN NUMBER)
AS
BEGIN
INSERT INTO EMPLOYEE VALUES(ID, NAME, SALARY);
END;
/

BEGIN
INSERTEMPLOYEE(20,'YASH AWAD',2000);
END;
/

SELECT * FROM EMPLOYEE;

 * 
 * ***/

public class ProcedureInsertExample {
	
	public static void main(String args[])
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","Seed","Seed123");
			
			CallableStatement stmt = conn.prepareCall("{call INSERTEMPLOYEE(?, ? ,?)}");
			
			System.out.println("Enter id:");
			int id  = sc.nextInt();
			
			System.out.println("Enter Name:");
			String name  = sc.next();
			
			System.out.println("Enter salary:");
			int salary  = sc.nextInt();
			
			stmt.setInt(1, id );
			
			stmt.setString(2, name);
			
			stmt.setInt(3, salary);
			
			if(stmt.executeUpdate()> 0)
			{
				System.out.print("Data Inserted Successfully");
			}else
			{
				System.out.print("Data not Inserted Successfully");
			}
			
			stmt.close();
			conn.close();
			sc.close();
			
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
