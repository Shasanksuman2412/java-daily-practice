public class Developer extends Employee implements Payable {

    Developer(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    double calculateSalary() {
        return baseSalary + (baseSalary * 0.10); // 10% bonus
    }

    @Override
    public void processPayment() {
        System.out.println("Processing payment for " + name + " (Developer)");
    }
}
