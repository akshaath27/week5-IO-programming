import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DatabaseToJsonReport {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        java.util.List<Map<String, Object>> records = new ArrayList<>();
        Connection conn = DriverManager.getConnection("jdbc:sqlite:sample.db");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
        while (rs.next()) {
            Map<String, Object> record = new HashMap<>();
            record.put("id", rs.getInt("id"));
            record.put("name", rs.getString("name"));
            record.put("salary", rs.getDouble("salary"));
            records.add(record);
        }
        rs.close();
        stmt.close();
        conn.close();
        mapper.writeValue(new java.io.File("report.json"), records);
    }
}