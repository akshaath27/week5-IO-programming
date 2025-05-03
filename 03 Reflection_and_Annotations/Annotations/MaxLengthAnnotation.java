import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@interface MaxLength {
    int value();
}

public class MaxLengthAnnotation {
    public static void main(String[] args) throws Exception {
        User user = new User("toolongusername");
        System.out.println(user.username);
    }
}

class User {
    @MaxLength(value = 10)
    String username;

    User(String username) {
        for (Field field : getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength max = field.getAnnotation(MaxLength.class);
                if (username.length() > max.value()) {
                    throw new IllegalArgumentException("Username exceeds max length");
                }
            }
        }
        this.username = username;
    }
}