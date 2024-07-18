package Day3;
import java.sql.*;
import java.util.StringTokenizer;

/*** Example on DatabaseMetaDataExample ***/ 

public class DatabaseMetaDataExample {
	
	public static void main(String args[])
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");  
		    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","Seed","Seed123");
			DatabaseMetaData dbmd=con.getMetaData();
			System.out.println("Driver Name :"+dbmd.getDriverName());
			System.out.println("Database Product:"+dbmd.getDatabaseProductName());
			System.out.println("Database Product Version "+dbmd.getDatabaseProductVersion());
			System.out.println("Driver Version"+dbmd.getDriverVersion());
			System.out.println("User name"+dbmd.getUserName());
			System.out.println("Quote String"+dbmd.getIdentifierQuoteString());
			System.out.println("\nSQL KYWORDS" +dbmd.getSQLKeywords());
			System.out.println("\nnumeric functions "+dbmd.getNumericFunctions());
			System.out.println("\nString functions "+dbmd.getStringFunctions());
			System.out.println("\nSystem functions " +dbmd.getSystemFunctions());
			System.out.println("\ntime date functions "+dbmd.getTimeDateFunctions());
			System.out.println("\nsearchString "+dbmd.getSearchStringEscape());
     		System.out.println("\n\nSQL KEYWORD SUPPORETD");
		 
			StringTokenizer st=new StringTokenizer(dbmd.getSQLKeywords(),",");
			while(st.hasMoreTokens())
				System.out.println(" "+st.nextToken());

			String [] tableTypes={"TABLE"};
			ResultSet allTables=dbmd.getTables(null,null,null,tableTypes);
			while(allTables.next())
			{
				String table_name=allTables.getString("TABLE_NAME");
				System.out.println("Table_NAME"+table_name);
				System.out.println("Indexes");

				
			}
	}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
	}


}
