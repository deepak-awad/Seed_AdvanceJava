package Day3;
import java.sql.*;
import javax.sql.rowset.*;

/*** Example on CachedRowSetExample ***/

public class CachedRowSetExample {
	
	public static void main(String[] args)throws Exception
	{ 
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			
			CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","Seed","Seed123"); 
			
			Statement st=con.createStatement(); 
			
			ResultSet rs=st.executeQuery("select *from Employee"); 
			
			crs.populate(rs);//populates the data into RowSet from ResultSet 
			rs.close(); 
			st.close(); 
			con.close();
			
			while(crs.next()) 
			{ 
			  System.out.print(crs.getInt(1)+"\t"); 
			  System.out.print(crs.getString(2)+"\t"); 
			  System.out.print(crs.getInt(3)+"\t"); 
			  System.out.println();
			} 

	 } 

}
