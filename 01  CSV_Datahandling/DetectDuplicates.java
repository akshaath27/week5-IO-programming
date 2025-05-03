import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

public class DetectDuplicates {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        HashSet<String> ids = new HashSet<>();
        String line = br.readLine();
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            String id = data[0];
            if (!ids.add(id)) {
                System.out.println("Duplicate record: " + line);
            }
        }
        br.close();
    }
}