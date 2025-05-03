import java.io.FileWriter;

public class WriteCSV {
    public static void main(String[] args) throws Exception {
        FileWriter writer = new FileWriter("employees.csv");
        writer.write("ID,Name,Department,Salary\n");
        writer.write("1,John,HR,50000\n");
        writer.write("2,Alice,IT,60000\n");
        writer.write("3,Bob,Finance,55000\n");
        writer.write("4,Clara,Marketing,52000\n");
        writer.write("5,David,IT,65000\n");
        writer.close();
    }
}