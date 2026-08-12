public class PatternMatchingDemo {

    // ---- Pattern matching for switch: matching on type ----
    static String describe(Object obj) {
        return switch (obj) {
            case Integer i -> "An integer: " + i;
            case String s -> "A string of length " + s.length();
            case Double d -> "A double: " + d;
            default -> "Something else";
        };
    }

    // ---- Pattern matching switch combined with a "when" guard clause ----
    static String categorize(Object obj) {
        return switch (obj) {
            case Integer i when i < 0 -> "Negative integer";
            case Integer i when i == 0 -> "Zero";
            case Integer i -> "Positive integer";
            default -> "Not an integer";
        };
    }

    public static void main(String[] args) {

        // ---- Old way: instanceof + manual cast (Day 13 style) ----
        Shape shape = new Circle(5);
        if (shape instanceof Circle) {
            Circle c = (Circle) shape; // separate cast line
            System.out.println("Old way - radius: " + c.getRadius());
        }
        System.out.println("---");

        // ---- Pattern matching for instanceof: check and cast combined ----
        if (shape instanceof Circle c) { // "c" is automatically available, already cast
            System.out.println("Pattern matching - radius: " + c.getRadius()); // no separate cast!
        }
        System.out.println("---");

        // ---- Combining with additional conditions ----
        if (shape instanceof Circle c && c.getRadius() > 3) {
            System.out.println("Large circle detected: radius " + c.getRadius());
        }
        System.out.println("---");

        // ---- Switch expressions: cleaner than switch statements ----
        Weekday today = Weekday.WEDNESDAY;
        String dayType = switch (today) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Weekday";
            case SATURDAY, SUNDAY -> "Weekend";
        };
        System.out.println(today + " is a: " + dayType);
        System.out.println("---");

        // ---- Pattern matching for switch: matching on type ----
        System.out.println(describe(42));
        System.out.println(describe("Hello"));
        System.out.println(describe(3.14));
        System.out.println(describe(true)); // falls to default
        System.out.println("---");

        // ---- Pattern matching switch with "when" guard clauses ----
        System.out.println(categorize(-5));
        System.out.println(categorize(0));
        System.out.println(categorize(10));
        System.out.println(categorize("not a number"));
        System.out.println("---");

        // ---- Pattern matching switch used with the Shape hierarchy ----
        Shape[] shapes = { new Circle(4), new Square(6) };
        for (Shape s : shapes) {
            String result = switch (s) {
                case Circle c -> "Circle with area: " + c.area();
                case Square sq -> "Square with area: " + sq.area();
                default -> "Unknown shape";
            };
            System.out.println(result);
        }
    }
}
