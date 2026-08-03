public class Student {
    private String name;
    private int rollNumber;
    private double marks;

    public Student(String name, int rollNumber, double marks) throws InvalidMarksException {
        this.name = name;
        this.rollNumber = rollNumber;
        setMarks(marks); // goes through validation even at creation
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) throws InvalidMarksException {
        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException("Marks must be between 0 and 100, got: " + marks);
        }
        this.marks = marks;
    }

    // ---- Used when saving to / loading from a file ----
    public String toFileFormat() {
        return rollNumber + "," + name + "," + marks;
    }

    public static Student fromFileFormat(String line) throws InvalidMarksException {
        String[] parts = line.split(",");
        int rollNumber = Integer.parseInt(parts[0]);
        String name = parts[1];
        double marks = Double.parseDouble(parts[2]);
        return new Student(name, rollNumber, marks);
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNumber + ", Name: " + name + ", Marks: " + marks;
    }
}
