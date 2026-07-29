public class Solutions {

    // ---- Exercise 1: isPrime as a reusable method ----
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    // ---- Exercise 2: Overloaded max method ----
    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int max(int a, int b, int c) {
        return max(max(a, b), c); // reuse the two-arg version
    }

    public static double max(double a, double b) {
        return (a > b) ? a : b;
    }

    // ---- Exercise 3: Recursive sum of digits ----
    public static int sumOfDigits(int n) {
        if (n == 0) {
            return 0; // base case
        }
        return (n % 10) + sumOfDigits(n / 10); // last digit + recurse on the rest
    }

    // ---- Exercise 4: Recursive string reversal ----
    public static String reverseString(String s) {
        if (s.length() <= 1) {
            return s; // base case: empty or single character
        }
        return reverseString(s.substring(1)) + s.charAt(0); // reverse of rest + first char
    }

    // ---- Exercise 5: Recursive power function ----
    public static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1; // base case
        }
        return base * power(base, exponent - 1); // recursive case
    }

    public static void main(String[] args) {

        // ---- Exercise 1 ----
        int[] testNumbers = {7, 15, 29};
        for (int n : testNumbers) {
            System.out.println(n + " is prime? " + isPrime(n));
        }
        System.out.println("---");

        // ---- Exercise 2 ----
        System.out.println("max(4, 9) = " + max(4, 9));
        System.out.println("max(4, 9, 6) = " + max(4, 9, 6));
        System.out.println("max(3.5, 2.1) = " + max(3.5, 2.1));
        System.out.println("---");

        // ---- Exercise 3 ----
        System.out.println("sumOfDigits(1234) = " + sumOfDigits(1234));
        System.out.println("---");

        // ---- Exercise 4 ----
        System.out.println("reverseString(\"hello\") = " + reverseString("hello"));
        System.out.println("---");

        // ---- Exercise 5 ----
        System.out.println("power(2, 5) = " + power(2, 5));
    }
}
