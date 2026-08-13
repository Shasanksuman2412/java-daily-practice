// non-sealed: this branch of the hierarchy is deliberately reopened -
// ANY class can now extend Triangle further, unlike Circle and Square.
public non-sealed class Triangle extends Shape {
    private final double base;
    private final double height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    double getBase() {
        return base;
    }

    double getHeight() {
        return height;
    }

    @Override
    double area() {
        return 0.5 * base * height;
    }
}
