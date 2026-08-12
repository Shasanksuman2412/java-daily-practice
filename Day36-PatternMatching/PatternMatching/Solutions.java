public class Solutions {

    // ---- Exercise 1: pattern matching instanceof, no separate cast lines ----
    static void describeOld(Object obj) {
        if (obj instanceof String s) {
            System.out.println("String of length " + s.length());
        } else if (obj instanceof Integer i) {
            System.out.println("Integer value: " + i);
        } else if (obj instanceof Double d) {
            System.out.println("Double value: " + d);
        } else {
            System.out.println("Unknown type");
        }
    }

    // ---- Exercise 2: switch expression for grading ----
    static char gradeFor(int marks) {
        return switch (marks / 10) {
            case 10, 9 -> 'A';
            case 8, 7 -> 'B';
            case 6 -> 'C';
            case 5, 4 -> 'D';
            default -> 'F';
        };
    }

    // ---- Exercise 3: pattern matching switch on Shape hierarchy ----
    static String describeShape(Shape s) {
        return switch (s) {
            case Circle c -> "Circle with radius " + c.getRadius() + ", area " + c.area();
            case Square sq -> "Square with side " + sq.getSide() + ", area " + sq.area();
            default -> "Unknown shape";
        };
    }

    // ---- Exercise 4: guard clauses for a number classifier ----
    static String classify(Object obj) {
        return switch (obj) {
            case Integer i when i < 0 -> "Negative int";
            case Integer i when i == 0 -> "Zero";
            case Integer i when i <= 100 -> "Small positive int"; // checked BEFORE the >100 case
            case Integer i -> "Large positive int";
            default -> "Not an integer";
        };
    }

    // ---- Exercise 5: instanceof pattern matching combined with a record ----
    static void describeRectangle(Object obj) {
        if (obj instanceof Rectangle r && r.width() == r.height()) {
            System.out.println("This is a square with side " + r.width());
        } else if (obj instanceof Rectangle r) {
            System.out.println("Rectangle with area: " + (r.width() * r.height()));
        } else {
            System.out.println("Not a rectangle at all.");
        }
    }

    public static void main(String[] args) {

        // ---- Exercise 1 ----
        describeOld("hello");
        describeOld(42);
        describeOld(3.14);
        System.out.println("---");

        // ---- Exercise 2 ----
        int[] testMarks = {95, 82, 65, 45, 20};
        for (int m : testMarks) {
            System.out.println(m + " -> Grade " + gradeFor(m));
        }
        System.out.println("---");

        // ---- Exercise 3 ----
        System.out.println(describeShape(new Circle(5)));
        System.out.println(describeShape(new Square(4)));
        System.out.println("---");

        // ---- Exercise 4 ----
        System.out.println(classify(-5));
        System.out.println(classify(0));
        System.out.println(classify(50));
        System.out.println(classify(500));
        System.out.println(classify("not a number"));
        System.out.println("---");

        // ---- Exercise 5 ----
        describeRectangle(new Rectangle(5, 5)); // square
        describeRectangle(new Rectangle(4, 8)); // regular rectangle
        describeRectangle("not a rectangle");
    }
}
