import java.io.BufferedReader;
import java.io.FileReader;

public class ReadLargeCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("large.csv"));
        br.readLine();
        int totalRecords = 0;
        String line;
        while ((line = br.readLine()) != null) {
            totalRecords++;
            if (totalRecords % 100 == 0) {
                System.out.println("Processed " + totalRecords + " records");
            }
        }
        System.out.println("Total records processed: " + totalRecords);
        br.close();
    }
}