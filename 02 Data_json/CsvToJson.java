import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CsvToJson {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        java.util.List<Map<String, String>> records = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader("input.csv"))) {
            String[] headers = reader.readNext();
            String[] row;
            while ((row = reader.readNext()) != null) {
                Map<String, String> record = new HashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    record.put(headers[i], row[i]);
                }
                records.add(record);
            }
        }
        mapper.writeValue(new java.io.File("output.json"), records);
    }
}