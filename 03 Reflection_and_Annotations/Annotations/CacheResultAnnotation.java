import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@interface CacheResult {}

public class CacheResultAnnotation {
    static Map<String, Object> cache = new HashMap<>();

    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        System.out.println(invokeWithCache(calc, "compute", 5));
        System.out.println(invokeWithCache(calc, "compute", 5));
    }

    static Object invokeWithCache(Object obj, String methodName, Object param) throws Exception {
        Method method = obj.getClass().getDeclaredMethod(methodName, int.class);
        if (method.isAnnotationPresent(CacheResult.class)) {
            String key = methodName + ":" + param;
            if (cache.containsKey(key)) {
                return cache.get(key);
            }
            Object result = method.invoke(obj, param);
            cache.put(key, result);
            return result;
        }
        return method.invoke(obj, param);
    }
}

class Calculator {
    @CacheResult
    int compute(int x) {
        return x * x;
    }
}