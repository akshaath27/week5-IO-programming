import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@interface JsonField {
    String name();
}

public class JsonFieldAnnotation {
    public static void main(String[] args) throws Exception {
        User user = new User("Alice");
        System.out.println(toJson(user));
    }

    static String toJson(Object obj) throws Exception {
        StringBuilder json = new StringBuilder("{");
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            String key = field.isAnnotationPresent(JsonField.class)
                    ? field.getAnnotation(JsonField.class).name()
                    : field.getName();
            json.append("\"").append(key).append("\":\"").append(field.get(obj)).append("\",");
        }
        json.setLength(json.length() - 1);
        return json.append("}").toString();
    }
}

class User {
    @JsonField(name = "user_name")
    String name;

    User(String name) {
        this.name = name;
    }
}