import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ExtractJsonFields {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(new File("input.json"));
        for (JsonNode node : json) {
            String name = node.get("name").asText();
            String email = node.get("email").asText();
            System.out.println("Name: " + name + ", Email: " + email);
        }
    }
}