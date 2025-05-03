import java.lang.reflect.Method;

public class InvokePrivateMethod {
    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        Method method = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(calc, 5, 3);
        System.out.println(result);
    }
}

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}