import java.util.Scanner;

public class Solutions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ---- Exercise 1: Simple calculator ----
        System.out.println("=== Exercise 1: Calculator ===");
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter an operator (+, -, *, /): ");
        String operator = scanner.next();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        try {
            double result;
            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/":
                    if (num2 == 0) throw new ArithmeticException("Cannot divide by zero");
                    result = num1 / num2;
                    break;
                default:
                    throw new IllegalArgumentException("Unknown operator: " + operator);
            }
            System.out.println("Result: " + result);
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.nextLine(); // consume leftover newline before the next nextLine() call
        System.out.println("---");

        // ---- Exercise 2: Fixing the nextInt/nextLine trap ----
        System.out.println("=== Exercise 2: Age and Name ===");
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume the leftover newline - THIS is the fix
        System.out.print("Enter your full name: ");
        String fullName = scanner.nextLine();
        System.out.println("Age: " + age + ", Name: " + fullName);
        System.out.println("---");

        // ---- Exercise 3: Input validation loop for a menu choice ----
        System.out.println("=== Exercise 3: Menu Choice ===");
        int choice = -1;
        while (true) {
            System.out.print("Enter a choice (1-3): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 3) {
                    break;
                } else {
                    System.out.println("Number out of range, must be 1-3.");
                }
            } else {
                System.out.println("That's not a number at all.");
                scanner.next(); // discard bad token
            }
        }
        System.out.println("Valid choice: " + choice);
        scanner.nextLine();
        System.out.println("---");

        // ---- Exercise 4: Interactive True/False quiz ----
        System.out.println("=== Exercise 4: Quiz ===");
        String[] questions = {
            "Java is platform-independent (true/false): ",
            "int is a reference type (true/false): ",
            "ArrayList has a fixed size (true/false): "
        };
        boolean[] correctAnswers = {true, false, false};
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.print(questions[i]);
            boolean userAnswer = scanner.nextBoolean();
            if (userAnswer == correctAnswers[i]) {
                score++;
            }
        }
        System.out.println("You scored " + score + " out of " + questions.length);
        scanner.nextLine();
        System.out.println("---");

        // ---- Exercise 5: Accumulate numbers until "done" ----
        System.out.println("=== Exercise 5: Sum until 'done' ===");
        double sum = 0;
        while (true) {
            System.out.print("Enter a number (or 'done' to finish): ");
            String input = scanner.next();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                double value = Double.parseDouble(input);
                sum += value;
            } catch (NumberFormatException e) {
                System.out.println("Not a valid number, skipping: " + input);
            }
        }
        System.out.println("Final sum: " + sum);

        scanner.close();
    }
}
