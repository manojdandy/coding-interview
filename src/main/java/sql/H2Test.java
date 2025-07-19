package sql;

import java.sql.*;

public class H2Test {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        Statement stmt = conn.createStatement();
        stmt.execute("CREATE TABLE employees (id INT, name VARCHAR)");
        stmt.execute("INSERT INTO employees VALUES (1, 'Alice'), (2, 'Bob')");
        ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

        while (rs.next()) {
            System.out.println(rs.getInt("id") + ": " + rs.getString("name"));
        }

        conn.close();
    }
}
