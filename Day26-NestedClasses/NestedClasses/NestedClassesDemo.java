public class NestedClassesDemo {
    public static void main(String[] args) {

        // ---- Static nested class: no Outer instance needed ----
        Outer.StaticNested nested = new Outer.StaticNested();
        nested.display();
        System.out.println("---");

        // ---- Inner class: needs an Outer instance to create ----
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner(); // note the unusual syntax
        inner.display();
        System.out.println("---");

        // ---- Different Outer instances give inner classes access to DIFFERENT data ----
        Outer outer2 = new Outer();
        Outer.Inner inner2 = outer2.new Inner();
        inner2.display(); // same output here since we didn't change the field, but tied to outer2
        System.out.println("---");

        // ---- Local class: defined and used inside a method ----
        outer.methodWithLocalClass();
        System.out.println("---");

        // ---- Anonymous class: no name, one-time use (recap from Day 19-style usage) ----
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous class implementation of Runnable");
            }
        };
        r.run();

        // ---- Anonymous class implementing a custom interface ----
        Greeter greeter = new Greeter() {
            @Override
            public void greet(String name) {
                System.out.println("Hello from an anonymous Greeter, " + name + "!");
            }
        };
        greeter.greet("Shasank");
    }
}

interface Greeter {
    void greet(String name);
}
