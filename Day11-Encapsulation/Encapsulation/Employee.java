public class Employee {

    private String name;
    private double salary;

    Employee(String name, double salary) {
        this.name = name;
        setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary, ignoring.");
        }
    }

    // ---- Exercise 5: private helper method ----
    private boolean isValidPercentage(double percentage) {
        return percentage > 0 && percentage <= 100;
    }

    // ---- Exercise 4: giveRaise using the private helper ----
    void giveRaise(double percentage) {
        if (isValidPercentage(percentage)) {
            salary += salary * (percentage / 100);
            System.out.println(name + " received a " + percentage + "% raise. New salary: " + salary);
        } else {
            System.out.println("Invalid raise percentage: " + percentage);
        }
    }
}
