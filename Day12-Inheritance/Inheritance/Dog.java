public class Dog extends Animal {

    Dog(String name) {
        super(name); // calls Animal's constructor to set the name field
    }

    void bark() {
        System.out.println(name + " is barking.");
    }

    // ---- Method overriding: redefining the parent's behavior ----
    @Override
    void makeSound() {
        super.makeSound(); // still runs Animal's generic version first
        System.out.println(name + " says: Woof!");
    }
}
