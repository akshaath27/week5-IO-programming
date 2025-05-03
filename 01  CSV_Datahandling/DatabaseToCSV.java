import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseToCSV {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "pass");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, name, department, salary FROM employees");
        FileWriter writer = new FileWriter("employees_report.csv");
        writer.write("Employee ID,Name,Department,Salary\n");
        while (rs.next()) {
            writer.write(String.format("%d,%s,%s,%.2f\n", 
                rs.getInt("id"), rs.getString("name"), 
                rs.getString("department"), rs.getDouble("salary")));
        }
        writer.close();
        rs.close();
        stmt.close();
        conn.close();
    }
}