import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface LogExecutionTime {}

public class LogExecutionTimeAnnotation {
    public static void main(String[] args) throws Exception {
        for (Method method : Operations.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                method.invoke(new Operations());
                long end = System.nanoTime();
                System.out.println(method.getName() + " took " + (end - start) / 1000000.0 + " ms");
            }
        }
    }
}

class Operations {
    @LogExecutionTime
    void slowTask() throws InterruptedException {
        Thread.sleep(100);
    }

    @LogExecutionTime
    void fastTask() {}
}