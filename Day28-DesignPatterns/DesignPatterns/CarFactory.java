public class CarFactory {
    private static CarFactory instance;

    private CarFactory() {
    }

    public static synchronized CarFactory getInstance() {
        if (instance == null) {
            instance = new CarFactory();
        }
        return instance;
    }

    public Car createCar(String model) {
        // uses the Builder internally, with sensible defaults
        return new Car.Builder(model).build();
    }
}
