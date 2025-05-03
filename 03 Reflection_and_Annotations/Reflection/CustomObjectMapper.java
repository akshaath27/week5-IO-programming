import java.lang.reflect.Field;
import java.util.Map;

public class CustomObjectMapper {
    public static void main(String[] args) throws Exception {
        Map<String, Object> props = Map.of("name", "Bob", "age", 25);
        Person person = toObject(Person.class, props);
        System.out.println(person.name + ", " + person.age);
    }

    static <T> T toObject(Class<T> clazz, Map<String, Object> props) throws Exception {
        T instance = clazz.getConstructor().newInstance();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (props.containsKey(field.getName())) {
                field.set(instance, props.get(field.getName()));
            }
        }
        return instance;
    }
}

class Person {
    String name;
    int age;
}