import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface RoleAllowed {
    String value();
}

public class RoleAllowedAnnotation {
    public static void main(String[] args) throws Exception {
        String userRole = "USER";
        for (Method method : AdminService.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed role = method.getAnnotation(RoleAllowed.class);
                if (!userRole.equals(role.value())) {
                    System.out.println("Access Denied for " + method.getName());
                } else {
                    method.invoke(new AdminService());
                }
            }
        }
    }
}

class AdminService {
    @RoleAllowed("ADMIN")
    void deleteUser() {
        System.out.println("User deleted");
    }
}