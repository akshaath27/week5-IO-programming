import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

public class TodoAnnotation {
    public static void main(String[] args) throws Exception {
        for (Method method : Project.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println(method.getName() + ": " + todo.task() + ", " + todo.assignedTo() + ", " + todo.priority());
            }
        }
    }
}

class Project {
    @Todo(task = "Implement login", assignedTo = "Bob", priority = "HIGH")
    void addLogin() {}

    @Todo(task = "Fix bugs", assignedTo = "Alice")
    void debug() {}
}