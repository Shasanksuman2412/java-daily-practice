public class EnumsDemo {
    public static void main(String[] args) {

        // ---- Basic enum usage ----
        Day today = Day.MONDAY;
        System.out.println("Today is: " + today);
        System.out.println("---");

        // ---- Using enums in switch ----
        switch (today) {
            case MONDAY:
                System.out.println("Start of the work week");
                break;
            case FRIDAY:
                System.out.println("Almost weekend!");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekend!");
                break;
            default:
                System.out.println("Another day");
        }
        System.out.println("---");

        // ---- Built-in enum methods ----
        Day day = Day.WEDNESDAY;
        System.out.println("name(): " + day.name());
        System.out.println("ordinal(): " + day.ordinal()); // position, starting at 0

        System.out.println("Looping through all days:");
        for (Day d : Day.values()) {
            System.out.println("- " + d + " (ordinal " + d.ordinal() + ")");
        }

        Day parsed = Day.valueOf("FRIDAY"); // String -> enum constant
        System.out.println("Parsed from String: " + parsed);
        System.out.println("---");

        // ---- Enum with fields, constructor, and methods ----
        double myMassOnEarth = 70; // kg
        System.out.println("If you weigh " + myMassOnEarth + " kg on Earth:");
        for (Planet p : Planet.values()) {
            System.out.printf("Your weight on %s: %.2f N%n", p, p.surfaceWeight(myMassOnEarth));
        }
        System.out.println("---");

        System.out.println("Earth's surface gravity: " + Planet.EARTH.surfaceGravity());
    }
}
