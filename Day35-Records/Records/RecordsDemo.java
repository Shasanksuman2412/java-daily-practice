public class RecordsDemo {
    public static void main(String[] args) {

        // ---- Basic record usage ----
        Point p1 = new Point(3, 4);
        System.out.println("p1.x(): " + p1.x());
        System.out.println("p1.y(): " + p1.y());
        System.out.println("toString(): " + p1); // auto-generated, readable format
        System.out.println("---");

        // ---- equals() and hashCode() for free ----
        Point p2 = new Point(3, 4);
        Point p3 = new Point(5, 6);
        System.out.println("p1.equals(p2) (same data)? " + p1.equals(p2)); // true
        System.out.println("p1.equals(p3) (different data)? " + p1.equals(p3)); // false
        System.out.println("p1.hashCode() == p2.hashCode()? " + (p1.hashCode() == p2.hashCode()));
        System.out.println("---");

        // ---- Records are immutable - no setters exist at all ----
        // p1.x = 10; // this line would NOT COMPILE - records have no setters
        System.out.println("Records cannot be modified after creation - no setter methods exist.");
        System.out.println("---");

        // ---- Compact constructor validation ----
        ValidatedPoint validPoint = new ValidatedPoint(5, 10);
        System.out.println("Valid point: " + validPoint);
        System.out.println("Distance from origin: " + validPoint.distanceFromOrigin());

        try {
            ValidatedPoint invalidPoint = new ValidatedPoint(-1, 5); // triggers validation
            System.out.println("Never reached: " + invalidPoint);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        System.out.println("---");

        // ---- Records implementing an interface ----
        ComparablePoint cp1 = new ComparablePoint(3, 0);
        ComparablePoint cp2 = new ComparablePoint(1, 0);
        System.out.println("cp1.compareTo(cp2): " + cp1.compareTo(cp2)); // positive, since 3 > 1
        System.out.println("---");

        // ---- Old-style class vs record: same behavior, WAY less code ----
        OldStylePoint old1 = new OldStylePoint(3, 4);
        OldStylePoint old2 = new OldStylePoint(3, 4);
        System.out.println("Old style toString(): " + old1);
        System.out.println("Old style equals() works too: " + old1.equals(old2));
        System.out.println("But it took ~30 lines of boilerplate to get there,");
        System.out.println("compared to Point's single-line record declaration.");
    }
}
