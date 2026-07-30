public class EncapsulationDemo {
    public static void main(String[] args) {

        // ---- Creating an object with valid data ----
        Student s1 = new Student("Shasank", 21, 85.5);
        s1.displayInfo();
        System.out.println("---");

        // ---- Trying to set invalid data through setters ----
        System.out.println("Attempting to set invalid age and marks:");
        s1.setAge(-5);       // rejected
        s1.setMarks(999);    // rejected
        s1.displayInfo();    // unchanged - still 21, 85.5
        System.out.println("---");

        // ---- Setting valid data through setters works fine ----
        s1.setAge(22);
        s1.setMarks(90.0);
        s1.displayInfo();
        System.out.println("---");

        // ---- Reading data safely through getters ----
        System.out.println("Name via getter: " + s1.getName());
        System.out.println("Age via getter: " + s1.getAge());
        System.out.println("Marks via getter: " + s1.getMarks());
        System.out.println("---");

        // ---- Even the constructor validates, since it calls the setters ----
        Student s2 = new Student("Priya", -10, 150.0); // both invalid
        s2.displayInfo(); // age and marks default to 0 since setters rejected them

        // Note: s1.age = -5 would NOT even compile here, since age is private!
        // That line is commented out on purpose - uncomment it to see the compile error:
        // s1.age = -5;
    }
}
