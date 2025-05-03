import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

public class TaskInfoAnnotation {
    public static void main(String[] args) throws Exception {
        for (Method method : TaskManager.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo info = method.getAnnotation(TaskInfo.class);
                System.out.println(method.getName() + ": " + info.priority() + ", " + info.assignedTo());
            }
        }
    }
}

class TaskManager {
    @TaskInfo(priority = "HIGH", assignedTo = "Alice")
    void processData() {}
}