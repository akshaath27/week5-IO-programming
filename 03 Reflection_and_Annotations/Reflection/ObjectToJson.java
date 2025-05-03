import java.lang.reflect.Field;

public class ObjectToJson {
    public static void main(String[] args) throws Exception {
        User user = new User("Alice", 30);
        System.out.println(toJson(user));
    }

    static String toJson(Object obj) throws Exception {
        StringBuilder json = new StringBuilder("{");
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            json.append("\"").append(field.getName()).append("\":\"").append(field.get(obj)).append("\",");
        }
        json.setLength(json.length() - 1);
        return json.append("}").toString();
    }
}

class User {
    String name;
    int age;

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}