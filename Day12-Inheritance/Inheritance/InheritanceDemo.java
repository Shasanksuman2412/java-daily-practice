public class InheritanceDemo {
    public static void main(String[] args) {

        // ---- Dog inherits eat() and sleep() from Animal, plus has its own bark() ----
        Dog d = new Dog("Rex");
        d.eat();    // inherited from Animal
        d.sleep();  // inherited from Animal
        d.bark();   // Dog's own method
        System.out.println("---");

        // ---- Method overriding: makeSound() behaves differently per subclass ----
        d.makeSound(); // Dog's overridden version (calls super first, then adds its own line)
        System.out.println("---");

        Cat c = new Cat("Whiskers");
        c.eat();       // inherited from Animal
        c.scratch();   // Cat's own method
        c.makeSound(); // Cat's overridden version (fully replaces the parent's)
        System.out.println("---");

        // ---- Polymorphism preview: treating a Dog/Cat as an Animal ----
        Animal a1 = new Dog("Buddy"); // an Animal reference pointing to a Dog object
        Animal a2 = new Cat("Milo");
        a1.makeSound(); // still calls Dog's version, not Animal's - this is polymorphism!
        a2.makeSound(); // still calls Cat's version
    }
}
