public class Square extends Shape implements Drawable {

    private double side;

    Square(double side) {
        this.side = side;
    }

    @Override
    double area() {
        return side * side;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a square with side " + side);
    }
}
