public class BankAccount {
    private double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        balance -= amount;
    }

    // ---- Inner class: tied to THIS specific BankAccount instance ----
    class TransactionLogger {
        void logTransaction(String type, double amount) {
            System.out.println("LOG: " + type + " " + amount + ", new balance: " + balance);
        }
    }
}
