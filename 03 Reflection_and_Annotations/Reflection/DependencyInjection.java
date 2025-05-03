import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

public class DependencyInjection {
    public static void main(String[] args) throws Exception {
        App app = injectDependencies(new App());
        app.service.perform();
    }

    static <T> T injectDependencies(T instance) throws Exception {
        for (Field field : instance.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                field.set(instance, field.getType().getConstructor().newInstance());
            }
        }
        return instance;
    }
}

class App {
    @Inject
    Service service;
}

class Service {
    void perform() {
        System.out.println("Service performed");
    }
}