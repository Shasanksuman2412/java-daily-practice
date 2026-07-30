public class BankAccount {

    private double balance;
    private String accountId; // Exercise 3: read-only after creation

    BankAccount(String accountId, double initialBalance) {
        this.accountId = accountId;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0; // reject invalid initial balance, default to 0
            System.out.println("Invalid initial balance, defaulting to 0.");
        }
    }

    // ---- Exercise 1: getter only, NO setter for balance ----
    public double getBalance() {
        return balance;
    }

    // ---- Exercise 3: getter only, NO setter for accountId ----
    public String getAccountId() {
        return accountId;
    }

    // ---- Exercise 2: controlled ways to change balance ----
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}
