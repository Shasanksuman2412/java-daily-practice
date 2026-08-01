public class Manager extends Employee implements Payable {

    Manager(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    double calculateSalary() {
        return baseSalary + 5000; // fixed bonus
    }

    @Override
    public void processPayment() {
        System.out.println("Processing payment for " + name + " (Manager)");
    }
}
