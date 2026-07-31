public class Cat extends Animal {

    Cat(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Meow!");
    }

    // Cat-only method, NOT available on the Animal reference directly
    void climbTree() {
        System.out.println(name + " climbs the tree!");
    }
}
