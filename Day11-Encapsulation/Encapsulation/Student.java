public class Student {

    // ---- Private fields: cannot be accessed directly from outside this class ----
    private String name;
    private int age;
    private double marks;

    // ---- Constructor: uses setters internally so validation applies even at creation ----
    Student(String name, int age, double marks) {
        this.name = name;
        setAge(age);     // goes through validation
        setMarks(marks); // goes through validation
    }

    // ---- Getters: read the value ----
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getMarks() {
        return marks;
    }

    // ---- Setters: write the value, WITH validation ----
    public void setAge(int age) {
        if (age > 0 && age < 120) {
            this.age = age;
        } else {
            System.out.println("Invalid age (" + age + "), ignoring.");
        }
    }

    public void setMarks(double marks) {
        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        } else {
            System.out.println("Invalid marks (" + marks + "), ignoring.");
        }
    }

    void displayInfo() {
        System.out.println(name + " is " + age + " years old with " + marks + " marks.");
    }
}
