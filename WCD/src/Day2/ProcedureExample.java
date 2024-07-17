package Day2;
import java.sql.*;
import java.util.Scanner;

/*** Procedure with example ***/

/*** 
 * with Function procedure
 * 
 * CREATE OR REPLACE FUNCTION addnum (NUM1 NUMBER, NUM2 NUMBER) RETURN NUMBER
IS
BEGIN 
RETURN NUM1+NUM2;
END;
/

select addnum(10,20) from dual;

with procedure 

CREATE OR REPLACE PROCEDURE MULNUM(NUM1 IN NUMBER, NUM2 IN NUMBER,RESULT OUT NUMBER)
AS
NUM3 NUMBER;
BEGIN 
RESULT := NUM1 * NUM2;
END;
/

drop procedure MULNUM;

SET SERVEROUTPUT ON;

BEGIN
  MULNUM(5, 7);
END;
/
 * ***/
public class ProcedureExample {
	
	public static void main(String args[])
	{
		try
		{
			Scanner sc1 = new Scanner(System.in);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","Seed","Seed123");
			
			System.out.println("Enter num1:");
			int num1 = sc1.nextInt();
			
			System.out.println("Enter num2:");
			int num2 = sc1.nextInt();
			
			CallableStatement stmt = conn.prepareCall("{call MULNUM(? , ?, ?)}");
			
			stmt.setInt(1,num1);
			
			stmt.setInt(2, num2);
			
			stmt.registerOutParameter(3, Types.INTEGER);
			
			stmt.execute();
			
			System.out.println("The addition is : "+ stmt.getInt(3));
			
			stmt.close();
			conn.close();
			sc1.close();
			
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
