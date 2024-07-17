package Day1;

import java.sql.*;
import java.util.Scanner;

public class JDBCConnection2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int id, salary;
        String name;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Seed", "Seed123");

            System.out.println("Enter id");
            id = sc.nextInt();

            System.out.println("Enter name");
            name = sc.next();

            System.out.println("Enter salary");
            salary = sc.nextInt();

            String sql = "INSERT INTO Employee VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, salary);

            ps.executeUpdate();

            ps.close();
            conn.close();
            sc.close();

            System.out.println("Data inserted successfully.");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
