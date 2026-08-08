public class Solutions {
    public static void main(String[] args) {

        // ---- Exercise 1: Singleton Logger ----
        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();
        System.out.println("l1 == l2 (same object)? " + (l1 == l2));
        l1.log("First message");
        l2.log("Second message");
        System.out.println("---");

        // ---- Exercise 2: Singleton with a counter ----
        System.out.println("Total logs so far (via l1): " + l1.getLogCount());
        Logger.getInstance().log("Third message"); // fresh getInstance() call, still same object
        System.out.println("Total logs after third call (via l2): " + l2.getLogCount());
        System.out.println("---");

        // ---- Exercise 3: Builder for Car ----
        Car car1 = new Car.Builder("Tesla Model 3")
                .color("Red")
                .sunroof()
                .build();
        Car car2 = new Car.Builder("Toyota Corolla")
                .manualTransmission()
                .build();
        System.out.println(car1);
        System.out.println(car2);
        System.out.println("---");

        // ---- Exercise 4: Builder with validation ----
        try {
            Car invalidCar = new Car.Builder("").build(); // empty model - should throw
            System.out.println(invalidCar); // never reached
        } catch (IllegalStateException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }
        System.out.println("---");

        // ---- Exercise 5: Combine both patterns ----
        CarFactory factory1 = CarFactory.getInstance();
        CarFactory factory2 = CarFactory.getInstance();
        System.out.println("factory1 == factory2 (Singleton confirmed)? " + (factory1 == factory2));

        Car factoryCar1 = factory1.createCar("Honda Civic");
        Car factoryCar2 = factory1.createCar("Ford Mustang");
        System.out.println("factoryCar1: " + factoryCar1);
        System.out.println("factoryCar2: " + factoryCar2);
        System.out.println("factoryCar1 == factoryCar2 (should be false, different objects)? " +
                (factoryCar1 == factoryCar2));
    }
}
