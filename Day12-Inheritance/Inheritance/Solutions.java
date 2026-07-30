public class Solutions {
    public static void main(String[] args) {

        // ---- Exercise 1, 2, 3: Car and Bike ----
        Car car = new Car("Toyota", 180);
        Bike bike = new Bike("Yamaha", 120);

        car.displayInfo();
        car.honk();
        car.openTrunk();
        System.out.println("---");

        bike.displayInfo();
        bike.honk();
        bike.pedalStand();
        System.out.println("---");

        // ---- Exercise 4: Polymorphism with an array of parent-type references ----
        Vehicle[] vehicles = {
            new Car("Honda", 160),
            new Bike("Royal Enfield", 100),
            new Car("Tesla", 250)
        };

        System.out.println("Polymorphism - honking all vehicles:");
        for (Vehicle v : vehicles) {
            v.honk(); // calls the correct overridden version each time
        }
        System.out.println("---");

        // ---- Exercise 5: Three-level inheritance ----
        SportsCar sc = new SportsCar("Ferrari", 300);
        sc.displayInfo(); // inherited (through Car) from Vehicle, plus Car's extra line
        sc.honk();        // SportsCar's own override
        sc.turboBoost();  // SportsCar's own method
    }
}
