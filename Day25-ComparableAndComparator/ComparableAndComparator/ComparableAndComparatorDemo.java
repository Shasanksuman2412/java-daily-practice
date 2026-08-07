import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class ComparableAndComparatorDemo {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("Shasank", 85));
        students.add(new Student("Priya", 92));
        students.add(new Student("Amit", 78));
        students.add(new Student("Neha", 85)); // same marks as Shasank, on purpose

        // ---- Comparable: uses the class's own compareTo() ----
        Collections.sort(students); // works because Student implements Comparable
        System.out.println("Sorted by natural order (marks, ascending):");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("---");

        // ---- Comparator: lambda-based external sorting ----
        Comparator<Student> byName = (a, b) -> a.name.compareTo(b.name);
        students.sort(byName);
        System.out.println("Sorted by name (alphabetical):");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("---");

        Comparator<Student> byMarksDescending = (a, b) -> b.marks - a.marks;
        students.sort(byMarksDescending);
        System.out.println("Sorted by marks (descending):");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("---");

        // ---- Comparator.comparing(): cleaner built-in helper ----
        students.sort(Comparator.comparing(s -> s.name));
        System.out.println("Sorted by name using Comparator.comparing():");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("---");

        students.sort(Comparator.comparing((Student s) -> s.marks).reversed());
        System.out.println("Sorted by marks descending using .reversed():");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("---");

        // ---- Chaining comparators: sort by marks, then break ties by name ----
        students.sort(
            Comparator.comparing((Student s) -> s.marks)
                      .thenComparing(s -> s.name)
        );
        System.out.println("Sorted by marks, ties broken by name:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
