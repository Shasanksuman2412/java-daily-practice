public class AbstractionDemo {
    public static void main(String[] args) {

        // ---- Cannot instantiate an abstract class directly ----
        // Shape s = new Shape(); // this line would NOT compile - uncomment to see the error

        // ---- Creating concrete subclasses ----
        Circle circle = new Circle(5);
        Square square = new Square(4);

        // ---- Using the shared, non-abstract method from Shape ----
        circle.display(); // uses area() internally, calls the correct override
        square.display();
        System.out.println("---");

        // ---- Using the interface method ----
        circle.draw();
        square.draw();
        System.out.println("---");

        // ---- Polymorphism through the abstract class type ----
        Shape[] shapes = { new Circle(3), new Square(6) };
        System.out.println("Looping through Shape array:");
        for (Shape shape : shapes) {
            shape.display(); // works for any current or future Shape subclass
        }
        System.out.println("---");

        // ---- Polymorphism through the interface type ----
        Drawable[] drawables = { new Circle(2), new Square(7) };
        System.out.println("Looping through Drawable array:");
        for (Drawable d : drawables) {
            d.draw(); // works for any class that implements Drawable
        }
    }
}
