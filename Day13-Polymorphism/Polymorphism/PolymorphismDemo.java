public class PolymorphismDemo {

    // ---- Compile-time polymorphism: method overloading ----
    static int add(int a, int b) {
        return a + b;
    }

    static double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {

        // ---- Overloading: decided at COMPILE time ----
        System.out.println("add(int, int) -> " + add(2, 3));
        System.out.println("add(double, double) -> " + add(2.5, 3.5));
        System.out.println("---");

        // ---- Runtime polymorphism: method overriding ----
        Animal a1 = new Dog("Rex");   // upcasting: Dog treated as Animal
        Animal a2 = new Cat("Milo");  // upcasting: Cat treated as Animal

        a1.makeSound(); // calls Dog's version, decided at RUNTIME
        a2.makeSound(); // calls Cat's version, decided at RUNTIME
        System.out.println("---");

        // ---- Why this matters: works for ANY Animal subclass, uniformly ----
        Animal[] animals = { new Dog("Rex"), new Cat("Milo"), new Dog("Buddy") };
        System.out.println("Looping through mixed Animal array:");
        for (Animal a : animals) {
            a.makeSound(); // correct version called every time, automatically
        }
        System.out.println("---");

        // ---- instanceof check ----
        System.out.println("a1 instanceof Dog: " + (a1 instanceof Dog));
        System.out.println("a1 instanceof Animal: " + (a1 instanceof Animal));
        System.out.println("a1 instanceof Cat: " + (a1 instanceof Cat));
        System.out.println("---");

        // ---- Downcasting: going from Animal reference back to Dog ----
        if (a1 instanceof Dog) {
            Dog d = (Dog) a1; // safe downcast, since we checked first
            d.fetch();        // now we can call Dog-specific methods
        }

        // ---- What happens WITHOUT checking instanceof first (commented out on purpose) ----
        // Cat wrongCast = (Cat) a1; // this would throw ClassCastException at runtime!
        // Uncomment the line above to see the crash - a1 is actually a Dog, not a Cat.
    }
}
