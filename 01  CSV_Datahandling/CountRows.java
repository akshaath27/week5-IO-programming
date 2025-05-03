import java.io.BufferedReader;
import java.io.FileReader;

public class CountRows {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        br.readLine();
        int count = 0;
        while (br.readLine() != null) {
            count++;
        }
        System.out.println("Number of records: " + count);
        br.close();
    }
}