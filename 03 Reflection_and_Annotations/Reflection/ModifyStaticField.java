import java.lang.reflect.Field;

public class ModifyStaticField {
    public static void main(String[] args) throws Exception {
        Field field = Configuration.class.getDeclaredField("API_KEY");
        field.setAccessible(true);
        field.set(null, "new-key-123");
        System.out.println(Configuration.API_KEY);
    }
}

class Configuration {
    private static String API_KEY = "old-key";
}