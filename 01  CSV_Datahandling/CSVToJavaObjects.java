import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

class Student {
    String id, name;
    int age, marks;
    Student(String id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Marks: " + marks;
    }
}

public class CSVToJavaObjects {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        List<Student> students = new ArrayList<>();
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            students.add(new Student(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3])));
        }
        students.forEach(System.out::println);
        br.close();
    }
}