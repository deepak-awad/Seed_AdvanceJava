package Day3;
import java.sql.*;
import javax.sql.rowset.*;

/*** Example on JDBCRowSetExample ***/

public class JDBCRowsetExample {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	 {

		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 String url="jdbc:oracle:thin:@localhost:1521:XE";
		 
		 JdbcRowSet rowset=RowSetProvider.newFactory().createJdbcRowSet();
		 rowset.setUrl(url);
		 rowset.setUsername("Seed");
		 rowset.setPassword("Seed123");
		 rowset.setCommand("select * from Employee");
		 rowset.execute();
		 while(rowset.next())
		 {
			System.out.println(" "+rowset.getInt(1)+" "+rowset.getString(2)+rowset.getInt(3)); 
		 }
	  }

}
