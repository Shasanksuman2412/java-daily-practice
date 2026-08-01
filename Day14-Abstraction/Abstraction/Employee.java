public abstract class Employee {

    protected String name;
    protected double baseSalary;

    Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    abstract double calculateSalary(); // subclasses MUST implement this

    void displayInfo() {
        System.out.println(name + "'s total salary: " + calculateSalary());
    }
}
