import java.util.List;

public class Solutions {

    // ---- Exercise 5: checkInputs, takes any Validator implementation ----
    static void checkInputs(List<String> inputs, Validator validator) {
        for (String input : inputs) {
            System.out.println("\"" + input + "\" valid? " + validator.isValid(input));
        }
    }

    public static void main(String[] args) {

        // ---- Exercise 1: static nested Result class ----
        Calculator.Result result = Calculator.calculate(5, 3);
        System.out.println("Sum: " + result.sum + ", Product: " + result.product);
        System.out.println("---");

        // ---- Exercise 2: inner class accessing outer state ----
        BankAccount account = new BankAccount(2000);
        BankAccount.TransactionLogger logger = account.new TransactionLogger();
        account.withdraw(500);
        logger.logTransaction("Withdrew", 500);
        System.out.println("---");

        // ---- Exercise 3: two different Outer instances, two different Inner instances ----
        BankAccount accountA = new BankAccount(1000);
        BankAccount accountB = new BankAccount(5000);
        BankAccount.TransactionLogger loggerA = accountA.new TransactionLogger();
        BankAccount.TransactionLogger loggerB = accountB.new TransactionLogger();

        accountA.deposit(200);
        accountB.withdraw(1000);
        loggerA.logTransaction("Deposited", 200);  // reports accountA's balance
        loggerB.logTransaction("Withdrew", 1000);  // reports accountB's balance, independently
        System.out.println("---");

        // ---- Exercise 4: local class inside a method ----
        processOrder(1500); // above 1000, gets discount
        processOrder(500);  // below 1000, no discount
        System.out.println("---");

        // ---- Exercise 5: anonymous class implementations of Validator ----
        List<String> inputs = List.of("", "hello", "hi", "programming");

        System.out.println("Checking 'not empty':");
        checkInputs(inputs, new Validator() {
            @Override
            public boolean isValid(String input) {
                return !input.isEmpty();
            }
        });

        System.out.println("Checking 'length > 5':");
        checkInputs(inputs, new Validator() {
            @Override
            public boolean isValid(String input) {
                return input.length() > 5;
            }
        });
    }

    // ---- Exercise 4: method containing a local class ----
    static void processOrder(double orderTotal) {
        class DiscountCalculator {
            double applyDiscount() {
                if (orderTotal > 1000) {
                    return orderTotal * 0.9; // 10% off
                }
                return orderTotal;
            }
        }
        DiscountCalculator calc = new DiscountCalculator();
        System.out.println("Order total: " + orderTotal + " -> Final price: " + calc.applyDiscount());
    }
}
