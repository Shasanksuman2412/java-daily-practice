public class Car extends Vehicle {

    Car(String brand, int speed) {
        super(brand, speed);
    }

    @Override
    void honk() {
        System.out.println("Beep beep!");
    }

    @Override
    void displayInfo() {
        super.displayInfo(); // prints inherited brand/speed first
        System.out.println("This is a four-wheeler.");
    }

    void openTrunk() {
        System.out.println(brand + "'s trunk is now open.");
    }
}
