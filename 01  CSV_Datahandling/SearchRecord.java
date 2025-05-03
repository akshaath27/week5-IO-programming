import java.io.BufferedReader;
import java.io.FileReader;

public class SearchRecord {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        String line = br.readLine();
        String searchName = "Alice";
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data[1].equals(searchName)) {
                System.out.printf("Department: %s, Salary: %s%n", data[2], data[3]);
                break;
            }
        }
        br.close();
    }
}