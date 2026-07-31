public class Dog extends Animal {

    Dog(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Woof!");
    }

    // Dog-only method, NOT available on the Animal reference directly
    void fetch() {
        System.out.println(name + " fetches the ball!");
    }
}
