public class Solutions {

    // ---- Exercise 1: Find the max of any number of ints ----
    static int max(int... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("max() requires at least one number");
        }
        int maxValue = numbers[0];
        for (int n : numbers) {
            if (n > maxValue) {
                maxValue = n;
            }
        }
        return maxValue;
    }

    // ---- Exercise 2: Join Strings with a separator, no leading/trailing separator ----
    static String joinWithSeparator(String separator, String... words) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (i < words.length - 1) { // only add separator BETWEEN words, not after the last one
                sb.append(separator);
            }
        }
        return sb.toString();
    }

    // ---- Exercise 3: Average, handling empty input gracefully ----
    static double average(double... numbers) {
        if (numbers.length == 0) {
            return 0.0; // avoid division by zero
        }
        double sum = 0;
        for (double n : numbers) {
            sum += n;
        }
        return sum / numbers.length;
    }

    // ---- Exercise 4: Varargs with a regular parameter for validation ----
    static boolean allAboveThreshold(int threshold, int... numbers) {
        for (int n : numbers) {
            if (n <= threshold) {
                return false;
            }
        }
        return true; // vacuously true for zero numbers - loop never runs, never returns false
    }

    // ---- Exercise 5: Overloaded methods with and without varargs ----
    static void describe(int a, int b) {
        System.out.println("Specific 2-arg overload called with: " + a + ", " + b);
    }

    static void describe(int... numbers) {
        System.out.println("Varargs overload called with " + numbers.length + " numbers");
    }

    public static void main(String[] args) {

        // ---- Exercise 1 ----
        System.out.println("max(5) = " + max(5));
        System.out.println("max(3, 9, 1) = " + max(3, 9, 1));
        try {
            max(); // should throw
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        System.out.println("---");

        // ---- Exercise 2 ----
        System.out.println(joinWithSeparator("-", "a", "b", "c"));
        System.out.println(joinWithSeparator(", ", "apple", "banana", "cherry"));
        System.out.println("---");

        // ---- Exercise 3 ----
        System.out.println("average(2, 4, 6) = " + average(2, 4, 6));
        System.out.println("average() (empty) = " + average());
        System.out.println("---");

        // ---- Exercise 4 ----
        System.out.println("allAboveThreshold(5, 6, 7, 8) = " + allAboveThreshold(5, 6, 7, 8)); // true
        System.out.println("allAboveThreshold(5, 6, 3, 8) = " + allAboveThreshold(5, 6, 3, 8)); // false
        System.out.println("allAboveThreshold(5) (no numbers) = " + allAboveThreshold(5));       // true
        System.out.println("---");

        // ---- Exercise 5 ----
        describe(1, 2);    // calls the SPECIFIC 2-arg overload - exact match wins
        describe(1, 2, 3); // calls the VARARGS overload - only option that fits 3 arguments
        // Java always prefers a non-varargs exact match over a varargs method
        // when both are technically callable with the given arguments.
    }
}
