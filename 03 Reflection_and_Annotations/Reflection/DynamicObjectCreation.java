import java.lang.reflect.Constructor;

public class DynamicObjectCreation {
    public static void main(String[] args) throws Exception {
        Constructor<Student> constructor = Student.class.getConstructor(String.class, int.class);
        Student student = constructor.newInstance("Alice", 20);
        System.out.println(student.name + ", " + student.age);
    }
}

class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}