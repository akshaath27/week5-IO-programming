import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class PrintJsonKeysValues {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(new File("input.json"));
        json.fields().forEachRemaining(entry -> {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        });
    }
}