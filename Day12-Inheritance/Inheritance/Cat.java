public class Cat extends Animal {

    Cat(String name) {
        super(name);
    }

    void scratch() {
        System.out.println(name + " is scratching.");
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Meow!"); // fully replaces parent's version
    }
}
