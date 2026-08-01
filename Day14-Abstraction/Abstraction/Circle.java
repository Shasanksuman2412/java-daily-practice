public class Circle extends Shape implements Drawable {

    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() { // MUST implement - required by abstract class Shape
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() { // MUST implement - required by interface Drawable
        System.out.println("Drawing a circle with radius " + radius);
    }
}
