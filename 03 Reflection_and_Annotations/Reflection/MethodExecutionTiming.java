import java.lang.reflect.Method;

public class MethodExecutionTiming {
    public static void main(String[] args) throws Exception {
        Operations ops = new Operations();
        for (Method method : Operations.class.getDeclaredMethods()) {
            long start = System.nanoTime();
            method.invoke(ops);
            long end = System.nanoTime();
            System.out.println(method.getName() + " took " + (end - start) / 1000000.0 + " ms");
        }
    }
}

class Operations {
    void task1() throws InterruptedException {
        Thread.sleep(50);
    }

    void task2() {}
}