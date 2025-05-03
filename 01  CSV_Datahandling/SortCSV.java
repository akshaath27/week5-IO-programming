import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class SortCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        List<String[]> records = new ArrayList<>();
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            records.add(line.split(","));
        }
        records.sort((a, b) -> Integer.compare(Integer.parseInt(b[3]), Integer.parseInt(a[3])));
        for (int i = 0; i < Math.min(5, records.size()); i++) {
            String[] data = records.get(i);
            System.out.printf("ID: %s, Name: %s, Department: %s, Salary: %s%n", 
                data[0], data[1], data[2], data[3]);
        }
        br.close();
    }
}