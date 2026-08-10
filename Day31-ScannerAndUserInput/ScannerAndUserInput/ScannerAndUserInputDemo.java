import java.util.Scanner;
import java.util.InputMismatchException;

public class ScannerAndUserInputDemo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // System.in = keyboard input

        // ---- Reading a String ----
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name);
        System.out.println("---");

        // ---- Reading different data types ----
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Enter your height in meters: ");
        double height = scanner.nextDouble();

        System.out.println("Age: " + age + ", Height: " + height);
        System.out.println("---");

        // ---- THE CLASSIC TRAP: nextInt() then nextLine() ----
        // After nextDouble() above, there's a leftover "\n" sitting in the buffer.
        // Without consuming it first, the next nextLine() would grab an EMPTY string.
        scanner.nextLine(); // consumes the leftover newline from nextDouble() above

        System.out.print("Enter your favorite quote: ");
        String quote = scanner.nextLine(); // now this works correctly
        System.out.println("Your quote: " + quote);
        System.out.println("---");

        // ---- Validating input safely with hasNextInt() ----
        System.out.print("Enter a whole number: ");
        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            System.out.println("You entered: " + num);
        } else {
            System.out.println("That's not a valid number!");
            scanner.next(); // consume the bad token so it doesn't get stuck
        }
        scanner.nextLine(); // consume leftover newline again
        System.out.println("---");

        // ---- Looping until valid input ----
        int positiveNumber;
        while (true) {
            System.out.print("Enter a POSITIVE number: ");
            if (scanner.hasNextInt()) {
                positiveNumber = scanner.nextInt();
                if (positiveNumber > 0) {
                    break; // valid, exit the loop
                } else {
                    System.out.println("Must be positive, try again.");
                }
            } else {
                System.out.println("Not a valid number, try again.");
                scanner.next(); // discard the invalid token
            }
        }
        System.out.println("Got a valid positive number: " + positiveNumber);
        scanner.nextLine();
        System.out.println("---");

        // ---- InputMismatchException handling ----
        System.out.print("Enter another number (try typing letters to see the error): ");
        try {
            int riskyNumber = scanner.nextInt();
            System.out.println("You entered: " + riskyNumber);
        } catch (InputMismatchException e) {
            System.out.println("Caught InputMismatchException: that wasn't a valid number!");
            scanner.next(); // clear the bad token
        }

        // ---- Always close the Scanner when completely done ----
        scanner.close();
    }
}
