public class Student {

    // ---- Fields (data each Student object holds) ----
    String name;
    int age;
    double marks;

    // ---- Constructor: runs automatically when a Student is created ----
    Student(String name, int age, double marks) {
        this.name = name;   // this.name = the field, name = the parameter
        this.age = age;
        this.marks = marks;
    }

    // ---- Method (behavior) ----
    void displayInfo() {
        System.out.println(name + " is " + age + " years old with " + marks + " marks.");
    }

    // ---- Another method, using the object's own fields ----
    boolean isPassing() {
        return marks >= 40;
    }
}
