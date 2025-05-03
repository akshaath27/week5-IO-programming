import java.lang.reflect.Field;

public class AccessPrivateField {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Field field = Person.class.getDeclaredField("age");
        field.setAccessible(true);
        field.set(person, 30);
        System.out.println(field.get(person));
    }
}

class Person {
    private int age;
}