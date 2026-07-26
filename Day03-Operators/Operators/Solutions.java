public class Solutions {
    public static void main(String[] args) {

        // ---- Exercise 1: Simple Calculator ----
        int num1 = 15, num2 = 4;
        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
        System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
        System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
        System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
        System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
        System.out.println("---");

        // ---- Exercise 2: Even or Odd ----
        int number = 27;
        boolean isEven = (number % 2 == 0);
        System.out.println("Is " + number + " even? " + isEven);
        System.out.println("---");

        // ---- Exercise 3: Swap using compound operators ----
        int a = 7;
        int b = 12;
        System.out.println("Before swap -> a: " + a + ", b: " + b);
        a += b;    // a = 7 + 12 = 19 (a now temporarily holds the sum)
        b = a - b; // b = 19 - 12 = 7  (b becomes original a)
        a -= b;    // a = 19 - 7 = 12  (a becomes original b)
        System.out.println("After swap  -> a: " + a + ", b: " + b);
        System.out.println("---");

        // ---- Exercise 4: Predict the output ----
        int x = 5;
        // x++ uses 5, THEN x becomes 6. Then ++x makes x 7, uses 7.
        // So: 5 + 7 = 12
        System.out.println(x++ + ++x); // 12
        System.out.println(x);         // 7

        int y = 10;
        // y > 5 is true, so && MUST evaluate the right side too (no short-circuit skip here)
        // y++ < 15 uses 10 (true), then y becomes 11
        boolean result = (y > 5) && (y++ < 15);
        System.out.println(result); // true
        System.out.println(y);      // 11
        System.out.println("---");

        // ---- Exercise 5: Grade average ----
        double m1 = 85.5, m2 = 90.0, m3 = 78.5;
        double average = (m1 + m2 + m3) / 3;
        System.out.println("Average: " + average);
        int roundedAvg = (int) average;
        boolean divisibleBy5 = (roundedAvg % 5 == 0);
        System.out.println("Rounded average divisible by 5? " + divisibleBy5);
    }
}
