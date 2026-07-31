public class Solutions {
    public static void main(String[] args) {

        // ---- Exercise 1: Shape hierarchy with overriding ----
        Circle c1 = new Circle(5);
        Square s1 = new Square(4);
        System.out.println("Circle area: " + c1.area());
        System.out.println("Square area: " + s1.area());
        System.out.println("---");

        // ---- Exercise 2: Polymorphic array of Shapes ----
        Shape[] shapes = {
            new Circle(3),
            new Square(6),
            new Circle(7),
            new Square(2)
        };

        System.out.println("Areas of all shapes:");
        for (Shape shape : shapes) {
            System.out.println(shape.area()); // correct area() runs automatically
        }
        System.out.println("---");

        // ---- Exercise 3: instanceof + downcasting ----
        System.out.println("Shape details via downcasting:");
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                Circle c = (Circle) shape;
                System.out.println("Circle with radius: " + c.getRadius());
            } else if (shape instanceof Square) {
                Square sq = (Square) shape;
                System.out.println("Square with side: " + sq.getSide());
            }
        }
        System.out.println("---");

        // ---- Exercise 4: Total area calculator (no instanceof needed) ----
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.area(); // purely polymorphic - no type checking at all
        }
        System.out.println("Total area of all shapes: " + totalArea);
        System.out.println("---");

        // ---- Exercise 5: Add a Rectangle without touching the loop above ----
        Shape[] shapesWithRectangle = {
            new Circle(3),
            new Square(6),
            new Circle(7),
            new Square(2),
            new Rectangle(4, 9) // NEW shape type added
        };

        double newTotalArea = 0;
        for (Shape shape : shapesWithRectangle) {
            newTotalArea += shape.area(); // SAME loop logic, zero changes needed
        }
        System.out.println("Total area including the new Rectangle: " + newTotalArea);
    }
}
