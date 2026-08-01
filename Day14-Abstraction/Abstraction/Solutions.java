public class Solutions {
    public static void main(String[] args) {

        // ---- Exercise 1, 2: Employee, Manager, Developer ----
        Manager m1 = new Manager("Shasank", 50000);
        Developer d1 = new Developer("Priya", 60000);

        m1.displayInfo();
        d1.displayInfo();
        System.out.println("---");

        // ---- Exercise 3: Payable interface ----
        m1.processPayment();
        d1.processPayment();
        System.out.println("---");

        // ---- Exercise 4: Polymorphic array using the abstract class type ----
        Employee[] employees = {
            new Manager("Amit", 55000),
            new Developer("Neha", 45000),
            new Manager("Raj", 62000),
            new Developer("Kavya", 48000)
        };

        System.out.println("All employee details:");
        for (Employee e : employees) {
            e.displayInfo(); // correct calculateSalary() runs automatically per type
        }
        System.out.println("---");

        // ---- Exercise 5: Total payroll using only abstraction ----
        double totalPayroll = 0;
        for (Employee e : employees) {
            totalPayroll += e.calculateSalary(); // no instanceof needed at all
        }
        System.out.println("Total payroll for all employees: " + totalPayroll);
    }
}
