import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;

public class ValidateCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("contacts.csv"));
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        String phoneRegex = "^\\d{10}$";
        String line = br.readLine();
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            String email = data[1];
            String phone = data[2];
            if (!Pattern.matches(emailRegex, email)) {
                System.out.printf("Invalid email in record: %s%n", line);
            }
            if (!Pattern.matches(phoneRegex, phone)) {
                System.out.printf("Invalid phone in record: %s%n", line);
            }
        }
        br.close();
    }
}