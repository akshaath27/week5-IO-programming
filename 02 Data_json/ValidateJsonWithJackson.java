import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ValidateJsonWithJackson {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.readTree(new File("input.json"));
            System.out.println("JSON is valid");
        } catch (Exception e) {
            System.out.println("Invalid JSON: " + e.getMessage());
        }
    }
}