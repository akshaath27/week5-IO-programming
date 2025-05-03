import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@interface BugReports {
    BugReport[] value();
}

public class BugReportAnnotation {
    public static void main(String[] args) throws Exception {
        for (Method method : TestClass.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(BugReports.class)) {
                BugReport[] reports = method.getAnnotationsByType(BugReport.class);
                for (BugReport report : reports) {
                    System.out.println(method.getName() + ": " + report.description());
                }
            }
        }
    }
}

class TestClass {
    @BugReport(description = "Null pointer issue")
    @BugReport(description = "Performance bug")
    void process() {}
}