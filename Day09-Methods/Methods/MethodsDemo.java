public class MethodsDemo {

    // ---- A method that returns a value ----
    public static int add(int a, int b) {
        return a + b;
    }

    // ---- A void method (no return value) ----
    public static void greet(String name) {
        System.out.println("Hello, " + name);
    }

    // ---- Method overloading: same name, different parameters ----
    public static double add(double a, double b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    // ---- Recursion: a method calling itself ----
    public static int factorial(int n) {
        if (n == 0) {
            return 1; // base case - stops the recursion
        }
        return n * factorial(n - 1); // recursive case
    }

    // ---- Recursion: Fibonacci sequence ----
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n; // base case
        }
        return fibonacci(n - 1) + fibonacci(n - 2); // recursive case
    }

    public static void main(String[] args) {

        // ---- Calling a method that returns a value ----
        int sum = add(5, 3);
        System.out.println("add(5, 3) = " + sum);
        System.out.println("---");

        // ---- Calling a void method ----
        greet("Shasank");
        System.out.println("---");

        // ---- Method overloading in action ----
        System.out.println("add(5, 3) int version -> " + add(5, 3));
        System.out.println("add(5.5, 3.2) double version -> " + add(5.5, 3.2));
        System.out.println("add(1, 2, 3) three-arg version -> " + add(1, 2, 3));
        System.out.println("---");

        // ---- Recursion: factorial ----
        int num = 5;
        System.out.println("Factorial of " + num + " = " + factorial(num));
        System.out.println("---");

        // ---- Recursion: fibonacci ----
        System.out.println("First 8 Fibonacci numbers:");
        for (int i = 0; i < 8; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
    }
}
