import java.util.Optional;
import java.util.List;

public class Solutions {

    // ---- Exercise 1: Safe division returning Optional ----
    static Optional<Integer> safeDivide(int a, int b) {
        if (b == 0) {
            return Optional.empty();
        }
        return Optional.of(a / b);
    }

    // ---- Exercise 3: Find a user by email using streams ----
    static Optional<String> findEmail(List<String> emails, String target) {
        return emails.stream()
                .filter(e -> e.equals(target))
                .findFirst(); // findFirst() itself already returns an Optional
    }

    // ---- Exercise 4: Optional chaining with flatMap ----
    static Optional<Student> findStudent(int id) {
        if (id == 101) {
            return Optional.of(new Student("Shasank", 101));
        }
        return Optional.empty();
    }

    static Optional<String> getEmail(Student s) {
        if (s.getRollNumber() == 101) {
            return Optional.of("shasank@example.com"); // has an email
        }
        return Optional.empty(); // simulates a student with no email on file
    }

    public static void main(String[] args) {

        // ---- Exercise 1 ----
        safeDivide(10, 2).ifPresentOrElse(
                result -> System.out.println("10 / 2 = " + result),
                () -> System.out.println("Cannot divide")
        );
        safeDivide(10, 0).ifPresentOrElse(
                result -> System.out.println("10 / 0 = " + result),
                () -> System.out.println("Cannot divide by zero")
        );
        System.out.println("---");

        // ---- Exercise 2: chained map/filter ----
        Optional<String> input = Optional.of("  hello world  ");
        String result = input
                .map(String::trim)
                .map(String::toUpperCase)
                .filter(s -> s.contains("WORLD"))
                .orElse("Not found");
        System.out.println("Chained result: " + result);
        System.out.println("---");

        // ---- Exercise 3 ----
        List<String> emails = List.of("a@x.com", "b@x.com", "c@x.com");
        System.out.println("Found b@x.com? " + findEmail(emails, "b@x.com").isPresent());
        System.out.println("Found z@x.com? " + findEmail(emails, "z@x.com").isPresent());
        System.out.println("---");

        // ---- Exercise 4: flatMap chaining ----
        // .map() here would give Optional<Optional<String>> - NOT useful.
        // .flatMap() "flattens" the nested Optional into a single-level one.
        Optional<String> studentEmail = findStudent(101).flatMap(Solutions::getEmail);
        System.out.println("Student 101's email: " + studentEmail.orElse("No email on file"));

        Optional<String> missingStudentEmail = findStudent(999).flatMap(Solutions::getEmail);
        System.out.println("Student 999's email: " + missingStudentEmail.orElse("No email on file"));
        System.out.println("---");

        // ---- Exercise 5: avoiding .get() at call sites ----
        // Call site 1: using orElseThrow instead of get() + manual null check
        try {
            Student s = findStudent(101)
                    .orElseThrow(() -> new IllegalStateException("Student not found"));
            System.out.println("Call site 1 - found: " + s);
        } catch (IllegalStateException e) {
            System.out.println("Call site 1 - error: " + e.getMessage());
        }

        // Call site 2: using orElse with a sensible default instead of get()
        Student fallbackStudent = findStudent(999).orElse(new Student("Unknown", -1));
        System.out.println("Call site 2 - result: " + fallbackStudent);
    }
}
