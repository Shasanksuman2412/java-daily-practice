public record ValidatedPoint(int x, int y) {

    // ---- Compact constructor: validation, no parameter list repeated ----
    public ValidatedPoint {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Coordinates cannot be negative: (" + x + ", " + y + ")");
        }
    }

    // ---- Records can have additional methods beyond the auto-generated ones ----
    double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }
}
