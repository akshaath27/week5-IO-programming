import java.io.BufferedReader;
import java.io.FileReader;

public class FilterRecords {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        String line = br.readLine();
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            int marks = Integer.parseInt(data[3]);
            if (marks > 80) {
                System.out.printf("ID: %s, Name: %s, Age: %s, Marks: %s%n", 
                    data[0], data[1], data[2], data[3]);
            }
        }
        br.close();
    }
}