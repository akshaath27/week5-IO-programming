import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class MergeCSV {
    public static void main(String[] args) throws Exception {
        HashMap<String, String[]> studentDetails = new HashMap<>();
        BufferedReader br1 = new BufferedReader(new FileReader("students1.csv"));
        br1.readLine();
        String line;
        while ((line = br1.readLine()) != null) {
            String[] data = line.split(",");
            studentDetails.put(data[0], new String[]{data[1], data[2]});
        }
        br1.close();

        FileWriter writer = new FileWriter("merged_students.csv");
        writer.write("ID,Name,Age,Marks,Grade\n");
        BufferedReader br2 = new BufferedReader(new FileReader("students2.csv"));
        br2.readLine();
        while ((line = br2.readLine()) != null) {
            String[] data = line.split(",");
            String[] details = studentDetails.get(data[0]);
            if (details != null) {
                writer.write(String.format("%s,%s,%s,%s,%s\n", 
                    data[0], details[0], details[1], data[1], data[2]));
            }
        }
        br2.close();
        writer.close();
    }
}