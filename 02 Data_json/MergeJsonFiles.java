import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJsonFiles {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json1 = mapper.readTree(new java.io.File("file1.json"));
        JsonNode json2 = mapper.readTree(new java.io.File("file2.json"));
        ObjectNode merged = mapper.createObjectNode();
        merged.setAll((ObjectNode) json1);
        merged.setAll((ObjectNode) json2);
        mapper.writeValue(new java.io.File("merged.json"), merged);
    }
}