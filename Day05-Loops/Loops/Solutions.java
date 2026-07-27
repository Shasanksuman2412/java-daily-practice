public class Solutions {
    public static void main(String[] args) {

        // ---- Exercise 1: Sum of first N natural numbers ----
        int n = 10;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("Sum of first " + n + " numbers: " + sum);
        System.out.println("---");

        // ---- Exercise 2: Multiplication Table ----
        int num = 7;
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
        System.out.println("---");

        // ---- Exercise 3: Reverse a number using while ----
        int number = 1234;
        int original = number; // keep original for printing later
        int reversed = 0;
        while (number != 0) {
            int lastDigit = number % 10;      // grab the last digit
            reversed = reversed * 10 + lastDigit; // shift and add it
            number = number / 10;              // remove the last digit
        }
        System.out.println("Reversed " + original + " -> " + reversed);
        System.out.println("---");

        // ---- Exercise 4: Number Pyramid Pattern ----
        int rows = 5;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println("---");

        // ---- Exercise 5: Prime number checker ----
        int candidate = 29;
        boolean isPrime = true;
        if (candidate <= 1) {
            isPrime = false; // 0 and 1 are not prime by definition
        } else {
            // only need to check up to candidate/2 -- no number bigger than
            // half of candidate can divide it evenly (except candidate itself)
            for (int i = 2; i <= candidate / 2; i++) {
                if (candidate % i == 0) {
                    isPrime = false;
                    break; // no need to keep checking once we find a divisor
                }
            }
        }
        System.out.println(candidate + " is " + (isPrime ? "Prime" : "Not Prime"));
    }
}
