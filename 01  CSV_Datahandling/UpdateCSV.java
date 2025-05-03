import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class UpdateCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        FileWriter writer = new FileWriter("updated_employees.csv");
        String line = br.readLine();
        writer.write(line + "\n");
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data[2].equals("IT")) {
                int salary = Integer.parseInt(data[3]);
                data[3] = String.valueOf((int)(salary * 1.1));
            }
            writer.write(String.join(",", data) + "\n");
        }
        br.close();
        writer.close();
    }
}