import java.lang.reflect.Method;

public class DynamicMethodInvocation {
    public static void main(String[] args) throws Exception {
        MathOperations math = new MathOperations();
        Method method = MathOperations.class.getMethod("multiply", int.class, int.class);
        int result = (int) method.invoke(math, 4, 5);
        System.out.println(result);
    }
}

class MathOperations {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
}