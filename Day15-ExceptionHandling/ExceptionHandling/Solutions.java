public class Solutions {

    // ---- Exercise 1: Safe division method ----
    static int safeDivide(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero, returning 0.");
            return 0;
        }
    }

    // ---- Exercise 2: Array bounds checker with multiple catches ----
    static void accessArray(int[] array, int index) {
        try {
            System.out.println("Value at index " + index + ": " + array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index " + index + " is out of bounds for this array");
        } finally {
            System.out.println("Access attempt finished.");
        }
    }

    // ---- Exercise 3: withdraw with custom checked exception ----
    static double withdraw(double balance, double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Cannot withdraw " + amount + ", balance is only " + balance);
        }
        return balance - amount;
    }

    // ---- Exercise 4: registerUser with two different exception types ----
    static void registerUser(String username, int age) throws InvalidAgeException {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (age < 13) {
            throw new InvalidAgeException("User must be at least 13 years old, got: " + age);
        }
        System.out.println("User " + username + " (age " + age + ") registered successfully.");
    }

    // ---- Exercise 5: try-catch-finally with a return value ----
    static int testFinally() {
        try {
            return 1;
        } finally {
            System.out.println("finally block ran");
        }
    }

    public static void main(String[] args) {

        // ---- Exercise 1 ----
        System.out.println("safeDivide(10, 2) = " + safeDivide(10, 2));
        System.out.println("safeDivide(10, 0) = " + safeDivide(10, 0));
        System.out.println("---");

        // ---- Exercise 2 ----
        int[] arr = {10, 20, 30};
        accessArray(arr, 1);   // valid
        accessArray(arr, 100); // invalid
        System.out.println("---");

        // ---- Exercise 3 ----
        try {
            double newBalance = withdraw(1000, 500); // valid
            System.out.println("New balance after valid withdrawal: " + newBalance);
            double failedBalance = withdraw(1000, 2000); // invalid, throws
            System.out.println("This line never runs: " + failedBalance);
        } catch (InsufficientFundsException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        System.out.println("---");

        // ---- Exercise 4 ----
        try {
            registerUser("Shasank", 21); // valid
            registerUser("", 21);        // throws IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        } catch (InvalidAgeException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        try {
            registerUser("YoungUser", 10); // throws InvalidAgeException
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        } catch (InvalidAgeException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        System.out.println("---");

        // ---- Exercise 5 ----
        // "finally block ran" prints BEFORE the method actually returns,
        // even though the return statement runs first inside try -
        // finally always executes before control leaves the method.
        int result = testFinally();
        System.out.println("testFinally() returned: " + result);
    }
}
