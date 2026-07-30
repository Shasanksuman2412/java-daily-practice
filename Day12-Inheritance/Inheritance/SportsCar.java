public class SportsCar extends Car {

    SportsCar(String brand, int speed) {
        super(brand, speed); // goes to Car's constructor, which goes to Vehicle's
    }

    @Override
    void honk() {
        System.out.println("VROOOOM honk!");
    }

    void turboBoost() {
        System.out.println(brand + " activates turbo boost!");
    }
}
