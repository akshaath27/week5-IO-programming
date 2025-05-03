import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;

public class ConvertListToJsonArray {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        java.util.List<Person> people = Arrays.asList(
            new Person("Alice", 25),
            new Person("Bob", 30)
        );
        String json = mapper.writeValueAsString(people);
        System.out.println(json);
    }

    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}