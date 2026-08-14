import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

public class OptionalDeepDiveDemo {

    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student("Shasank", 101));
        students.add(new Student("Priya", 102));
    }

    // ---- Using Optional as a return type: the real intended use ----
    static Optional<Student> findByRollNumber(int rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber() == rollNumber) {
                return Optional.of(s);
            }
        }
        return Optional.empty(); // explicit "not found" - forces caller to handle it
    }

    public static void main(String[] args) {

        // ---- Creating an Optional ----
        Optional<String> present = Optional.of("Hello");
        Optional<String> empty = Optional.empty();
        Optional<String> maybeNull = Optional.ofNullable(null); // safe - doesn't throw
        System.out.println("present: " + present);
        System.out.println("empty: " + empty);
        System.out.println("maybeNull: " + maybeNull);
        System.out.println("---");

        // ---- Checking and safely retrieving values ----
        System.out.println("present.isPresent(): " + present.isPresent());
        System.out.println("empty.isEmpty(): " + empty.isEmpty());

        if (present.isPresent()) {
            System.out.println("Safely retrieved: " + present.get());
        }
        System.out.println("---");

        // ---- .get() on empty throws NoSuchElementException ----
        try {
            String value = empty.get(); // never checked first - crashes
            System.out.println("Never reached: " + value);
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        System.out.println("---");

        // ---- The better way: avoid .get() entirely ----
        present.ifPresent(v -> System.out.println("ifPresent ran: " + v));
        empty.ifPresent(v -> System.out.println("This never prints, empty has no value"));

        String fallback = empty.orElse("Default Value");
        System.out.println("orElse fallback: " + fallback);

        String computed = empty.orElseGet(() -> {
            System.out.println("(computing fallback lazily...)");
            return "Computed Default";
        });
        System.out.println("orElseGet fallback: " + computed);

        try {
            empty.orElseThrow(() -> new IllegalStateException("Value is required!"));
        } catch (IllegalStateException e) {
            System.out.println("Caught from orElseThrow: " + e.getMessage());
        }
        System.out.println("---");

        // ---- Chaining transformations: map() and filter() ----
        Optional<String> name = Optional.of("shasank");
        Optional<String> upper = name.map(String::toUpperCase);
        System.out.println("Mapped to uppercase: " + upper.get());

        Optional<String> longName = name.filter(n -> n.length() > 10);
        System.out.println("Filtered (length > 10) is present? " + longName.isPresent());
        System.out.println("---");

        // ---- Using Optional as a return type: the real payoff ----
        findByRollNumber(101).ifPresentOrElse(
                s -> System.out.println("Found: " + s),
                () -> System.out.println("Not found")
        );

        findByRollNumber(999).ifPresentOrElse(
                s -> System.out.println("Found: " + s),
                () -> System.out.println("Not found")
        );
    }
}
