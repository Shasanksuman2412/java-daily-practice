public class Student implements Comparable<Student> {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    // ---- Natural sort order: ascending by marks ----
    @Override
    public int compareTo(Student other) {
        return this.marks - other.marks;
        // negative -> this comes before other
        // zero     -> considered equal for sorting
        // positive -> this comes after other
    }

    @Override
    public String toString() {
        return name + " (" + marks + ")";
    }
}
