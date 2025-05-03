import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface ImportantMethod {
    String level() default "HIGH";
}

public class ImportantMethodAnnotation {
    public static void main(String[] args) throws Exception {
        for (Method method : Processor.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println(method.getName() + ": " + annotation.level());
            }
        }
    }
}

class Processor {
    @ImportantMethod(level = "HIGH")
    void criticalTask() {}

    @ImportantMethod(level = "MEDIUM")
    void regularTask() {}
}