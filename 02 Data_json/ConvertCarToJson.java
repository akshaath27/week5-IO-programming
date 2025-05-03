import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertCarToJson {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Car car = new Car("Toyota", "Camry", 2020);
        String json = mapper.writeValueAsString(car);
        System.out.println(json);
    }

    static class Car {
        String brand;
        String model;
        int year;

        public Car(String brand, String model, int year) {
            this.brand = brand;
            this.model = model;
            this.year = year;
        }
    }
}