public class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    double getRadius() { // Circle-specific getter, needed for downcasting in Exercise 3
        return radius;
    }
}
