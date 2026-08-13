// Because Triangle is non-sealed, ANY class (even outside the original
// sealed hierarchy's control) can extend it freely, like a normal class.
public class RightTriangle extends Triangle {
    RightTriangle(double base, double height) {
        super(base, height);
    }

    boolean isValidRightTriangle() {
        return getBase() > 0 && getHeight() > 0; // simplified check for the demo
    }
}
