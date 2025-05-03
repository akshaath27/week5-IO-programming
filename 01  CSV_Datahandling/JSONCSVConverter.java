import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONCSVConverter {
    public static void main(String[] args) throws Exception {
        String jsonString = new String(Files.readAllBytes(Paths.get("students.json")));
        JSONArray jsonArray = new JSONArray(jsonString);
        FileWriter csvWriter = new FileWriter("students.csv");
        csvWriter.write("ID,Name,Age,Marks\n");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            csvWriter.write(String.format("%s,%s,%d,%d\n", 
                obj.getString("id"), obj.getString("name"), 
                obj.getInt("age"), obj.getInt("marks")));
        }
        csvWriter.close();

        BufferedReader csvReader = new BufferedReader(new FileReader("students.csv"));
        JSONArray newJsonArray = new JSONArray();
        csvReader.readLine();
        String line;
        while ((line = csvReader.readLine()) != null) {
            String[] data = line.split(",");
            JSONObject obj = new JSONObject();
            obj.put("id", data[0]);
            obj.put("name", data[1]);
            obj.put("age", Integer.parseInt(data[2]));
            obj.put("marks", Integer.parseInt(data[3]));
            newJsonArray.put(obj);
        }
        Files.writeString(Paths.get("new_students.json"), newJsonArray.toString());
        csvReader.close();
    }
}