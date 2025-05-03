import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Base64;

public class EncryptDecryptCSV {
    private static final String KEY = "MySecretKey12345";
    
    private static String encrypt(String data) throws Exception {
        SecretKeySpec key = new SecretKeySpec(KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }
    
    private static String decrypt(String data) throws Exception {
        SecretKeySpec key = new SecretKeySpec(KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(data));
        return new String(decrypted);
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        FileWriter writer = new FileWriter("encrypted_employees.csv");
        String line = br.readLine();
        writer.write("ID,Name,Department,Salary,Email\n");
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            String encryptedSalary = encrypt(data[3]);
            String encryptedEmail = encrypt(data[4]);
            writer.write(String.format("%s,%s,%s,%s,%s\n", 
                data[0], data[1], data[2], encryptedSalary, encryptedEmail));
        }
        br.close();
        writer.close();

        BufferedReader br2 = new BufferedReader(new FileReader("encrypted_employees.csv"));
        br2.readLine();
        while ((line = br2.readLine()) != null) {
            String[] data = line.split(",");
            String decryptedSalary = decrypt(data[3]);
            String decryptedEmail = decrypt(data[4]);
            System.out.printf("ID: %s, Name: %s, Department: %s, Salary: %s, Email: %s%n",
                data[0], data[1], data[2], decryptedSalary, decryptedEmail);
        }
        br2.close();
    }
}