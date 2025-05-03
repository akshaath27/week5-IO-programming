import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonToXml {
    public static void main(String[] args) throws Exception {
        ObjectMapper jsonMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();
        java.util.Map<String, Object> data = jsonMapper.readValue(new java.io.File("input.json"), java.util.Map.class);
        String xml = xmlMapper.writeValueAsString(data);
        System.out.println(xml);
    }
}