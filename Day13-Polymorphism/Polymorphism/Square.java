public class Square extends Shape {
    private double side;

    Square(double side) {
        this.side = side;
    }

    @Override
    double area() {
        return side * side;
    }

    double getSide() { // Square-specific getter, needed for downcasting in Exercise 3
        return side;
    }
}
