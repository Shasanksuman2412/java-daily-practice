import java.util.Optional;

public class StudentManagementSystem {
    public static void main(String[] args) {

        StudentManager manager = new StudentManager();

        // ---- Try loading existing records first ----
        manager.loadFromFile();
        System.out.println("---");

        // ---- Adding students, handling the custom checked exception ----
        try {
            manager.addStudent(new Student("Shasank", 101, 85.5));
            manager.addStudent(new Student("Priya", 102, 92.0));
            manager.addStudent(new Student("Amit", 103, 78.0));
            manager.addStudent(new Student("Neha", 104, 65.5));

            // this one is INVALID (marks > 100) - exception will be caught below
            manager.addStudent(new Student("BadRecord", 105, 150.0));

        } catch (InvalidMarksException e) {
            System.out.println("Could not add student: " + e.getMessage());
        }
        System.out.println("---");

        // ---- Display all students ----
        System.out.println("All students:");
        manager.displayAll();
        System.out.println("---");

        // ---- Search by roll number ----
        Optional<Student> found = manager.findByRollNumber(102);
        if (found.isPresent()) {
            System.out.println("Found: " + found.get());
        } else {
            System.out.println("Student not found.");
        }
        System.out.println("---");

        // ---- Class average and top scorer (using streams) ----
        System.out.println("Class average: " + manager.classAverage());
        Optional<Student> top = manager.topScorer();
        top.ifPresent(s -> System.out.println("Top scorer: " + s));
        System.out.println("---");

        // ---- Delete a student ----
        boolean deleted = manager.deleteStudent(103);
        System.out.println("Deleted roll 103? " + deleted);
        System.out.println("Students after deletion:");
        manager.displayAll();
        System.out.println("---");

        // ---- Save everything to file for next time ----
        manager.saveToFile();
    }
}
