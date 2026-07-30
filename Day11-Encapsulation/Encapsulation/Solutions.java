public class Solutions {
    public static void main(String[] args) {

        // ---- Exercise 1, 2, 3: BankAccount ----
        BankAccount acc1 = new BankAccount("ACC1001", 1000.0);
        System.out.println("Account ID: " + acc1.getAccountId());
        System.out.println("Initial balance: " + acc1.getBalance());

        acc1.deposit(500);
        acc1.withdraw(2000); // should fail - more than balance
        acc1.withdraw(300);  // should succeed

        BankAccount acc2 = new BankAccount("ACC1002", -50); // invalid initial balance
        System.out.println("Account 2 balance (after invalid init): " + acc2.getBalance());
        System.out.println("---");

        // ---- Exercise 4, 5: Employee ----
        Employee e1 = new Employee("Shasank", 50000.0);
        Employee e2 = new Employee("Priya", 60000.0);

        System.out.println(e1.getName() + "'s salary before raise: " + e1.getSalary());
        e1.giveRaise(150); // invalid - should be rejected
        e1.giveRaise(10);  // valid
        System.out.println(e1.getName() + "'s salary after raise: " + e1.getSalary());

        System.out.println(e2.getName() + "'s salary before raise: " + e2.getSalary());
        e2.giveRaise(20);
        System.out.println(e2.getName() + "'s salary after raise: " + e2.getSalary());
    }
}
