import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJsonObjects {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode obj1 = mapper.createObjectNode().put("name", "John").put("age", 30);
        ObjectNode obj2 = mapper.createObjectNode().put("email", "john@example.com").put("city", "New York");
        ObjectNode merged = mapper.createObjectNode();
        merged.setAll(obj1);
        merged.setAll(obj2);
        System.out.println(mapper.writeValueAsString(merged));
    }
}