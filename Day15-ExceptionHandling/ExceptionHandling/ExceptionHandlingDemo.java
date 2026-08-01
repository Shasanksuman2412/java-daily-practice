public class ExceptionHandlingDemo {

    // ---- Method that THROWS a custom checked exception ----
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be negative: " + age);
        }
        if (age < 18) {
            throw new InvalidAgeException("Must be 18 or older, got: " + age);
        }
        System.out.println("Age " + age + " is valid.");
    }

    public static void main(String[] args) {

        // ---- Basic try-catch ----
        try {
            int result = 10 / 0; // throws ArithmeticException
            System.out.println(result); // never reached
        } catch (ArithmeticException e) {
            System.out.println("Caught: Can't divide by zero - " + e.getMessage());
        }
        System.out.println("Program continues normally after the catch.");
        System.out.println("---");

        // ---- Multiple catch blocks ----
        int[] numbers = {1, 2, 3};
        try {
            System.out.println(numbers[5]); // throws ArrayIndexOutOfBoundsException
        } catch (ArithmeticException e) {
            System.out.println("Math error: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Bad array index: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Some other error: " + e.getMessage());
        }
        System.out.println("---");

        // ---- finally: always runs ----
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Error caught in try-catch");
        } finally {
            System.out.println("This ALWAYS runs, error or not.");
        }
        System.out.println("---");

        // ---- throw + custom checked exception, handled with try-catch ----
        try {
            validateAge(25);   // valid, prints success message
            validateAge(-5);   // throws InvalidAgeException
        } catch (InvalidAgeException e) {
            System.out.println("Caught custom exception: " + e.getMessage());
        }
        System.out.println("---");

        // ---- Unchecked exception example: NullPointerException ----
        try {
            String text = null;
            System.out.println(text.length()); // throws NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught NPE: tried to use a null reference.");
        }
    }
}
