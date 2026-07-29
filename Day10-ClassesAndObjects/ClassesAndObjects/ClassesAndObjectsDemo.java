public class ClassesAndObjectsDemo {
    public static void main(String[] args) {

        // ---- Creating an object using the constructor ----
        Student s1 = new Student("Shasank", 21, 85.5);
        s1.displayInfo();
        System.out.println("Is passing? " + s1.isPassing());
        System.out.println("---");

        // ---- Creating a second, independent object ----
        Student s2 = new Student("Priya", 22, 32.0);
        s2.displayInfo();
        System.out.println("Is passing? " + s2.isPassing());
        System.out.println("---");

        // ---- Each object has its OWN separate data ----
        System.out.println("s1's name: " + s1.name + ", s2's name: " + s2.name);
        s1.marks = 90.0; // changing s1 does NOT affect s2
        System.out.println("After updating s1's marks:");
        s1.displayInfo();
        s2.displayInfo(); // s2 is completely unaffected
        System.out.println("---");

        // ---- Array of objects ----
        Student[] students = {
            new Student("Amit", 20, 45.0),
            new Student("Neha", 23, 78.0),
            new Student("Raj", 21, 25.0)
        };

        System.out.println("All students:");
        for (Student s : students) {
            s.displayInfo();
        }
    }
}
