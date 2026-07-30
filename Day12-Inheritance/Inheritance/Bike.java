public class Bike extends Vehicle {

    Bike(String brand, int speed) {
        super(brand, speed);
    }

    @Override
    void honk() {
        System.out.println("Tring tring!");
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("This is a two-wheeler.");
    }

    void pedalStand() {
        System.out.println(brand + " is on its pedal stand.");
    }
}
