import java.util.HashSet;
import java.util.Set;

public class ObjectMethodsDemo {
    public static void main(String[] args) {

        // ---- Default toString() and equals() - not very useful ----
        StudentWithoutOverrides sw1 = new StudentWithoutOverrides("Shasank", 21);
        StudentWithoutOverrides sw2 = new StudentWithoutOverrides("Shasank", 21);

        System.out.println("Default toString(): " + sw1); // something like StudentWithoutOverrides@1b6d3586
        System.out.println("Default equals() (identical data): " + sw1.equals(sw2)); // false! different objects
        System.out.println("---");

        // ---- Overridden toString() ----
        Student s1 = new Student("Shasank", 21);
        Student s2 = new Student("Shasank", 21);
        Student s3 = new Student("Priya", 22);

        System.out.println("Overridden toString(): " + s1);
        System.out.println("---");

        // ---- Overridden equals() ----
        System.out.println("s1.equals(s2) (same data)? " + s1.equals(s2));   // true now!
        System.out.println("s1.equals(s3) (different data)? " + s1.equals(s3)); // false
        System.out.println("s1 == s2 (reference comparison)? " + (s1 == s2)); // still false - different objects in memory
        System.out.println("---");

        // ---- hashCode() consistency with equals() ----
        System.out.println("s1.hashCode(): " + s1.hashCode());
        System.out.println("s2.hashCode(): " + s2.hashCode());
        System.out.println("Same hashCode for equal objects? " + (s1.hashCode() == s2.hashCode()));
        System.out.println("---");

        // ---- Why this matters: HashSet behavior WITHOUT proper overrides ----
        Set<StudentWithoutOverrides> setWithoutOverrides = new HashSet<>();
        setWithoutOverrides.add(new StudentWithoutOverrides("Shasank", 21));
        setWithoutOverrides.add(new StudentWithoutOverrides("Shasank", 21)); // "duplicate" data
        System.out.println("HashSet size WITHOUT overrides (should be duplicate): " + setWithoutOverrides.size());
        // prints 2 - wrongly treated as two different students!
        System.out.println("---");

        // ---- HashSet behavior WITH proper overrides ----
        Set<Student> setWithOverrides = new HashSet<>();
        setWithOverrides.add(new Student("Shasank", 21));
        setWithOverrides.add(new Student("Shasank", 21)); // same data
        System.out.println("HashSet size WITH overrides (correctly a duplicate): " + setWithOverrides.size());
        // prints 1 - correctly recognized as the same student
    }
}
