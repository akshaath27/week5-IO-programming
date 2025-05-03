import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;

public class FilterJsonByAge {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(new File("input.json"));
        java.util.List<Object> filtered = new ArrayList<>();
        for (JsonNode node : json) {
            if (node.get("age").asInt() > 25) {
                filtered.add(mapper.treeToValue(node, Object.class));
            }
        }
        System.out.println(mapper.writeValueAsString(filtered));
    }
}