public class Solutions {

    // ---- Exercise 2: Palindrome check using StringBuilder.reverse() ----
    static boolean isPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }

    public static void main(String[] args) {

        // ---- Exercise 1: Build a CSV row ----
        String[] fields = {"Shasank", "21", "Java Developer"};
        StringBuilder csv = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            csv.append(fields[i]);
            if (i < fields.length - 1) {
                csv.append(",");
            }
        }
        System.out.println("CSV row: " + csv);
        System.out.println("---");

        // ---- Exercise 2 ----
        System.out.println("\"madam\" is palindrome? " + isPalindrome("madam"));
        System.out.println("\"hello\" is palindrome? " + isPalindrome("hello"));
        System.out.println("---");

        // ---- Exercise 3: Remove all vowels, looping BACKWARDS ----
        StringBuilder text = new StringBuilder("Programming is powerful");
        String vowels = "aeiouAEIOU";
        for (int i = text.length() - 1; i >= 0; i--) { // backwards, so deletion doesn't skip characters
            if (vowels.indexOf(text.charAt(i)) != -1) {
                text.deleteCharAt(i);
            }
        }
        System.out.println("Without vowels: " + text);
        System.out.println("---");

        // ---- Exercise 4: Running total with insert/replace ----
        StringBuilder totalTracker = new StringBuilder("Total: 0");
        int total = 0;

        int[] amountsToAdd = {50, 30, 20};
        for (int amount : amountsToAdd) {
            total += amount;
            int numberStart = totalTracker.indexOf(": ") + 2; // position right after "Total: "
            totalTracker.replace(numberStart, totalTracker.length(), String.valueOf(total));
            System.out.println(totalTracker);
        }
        System.out.println("---");

        // ---- Exercise 5: Performance comparison ----
        int iterations = 50000;

        long start1 = System.currentTimeMillis();
        String concatenated = "";
        for (int i = 0; i < iterations; i++) {
            concatenated += "a"; // creates a NEW String object every single iteration
        }
        long end1 = System.currentTimeMillis();
        System.out.println("String concatenation took: " + (end1 - start1) + "ms");

        long start2 = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            builder.append("a"); // modifies the SAME object in place
        }
        long end2 = System.currentTimeMillis();
        System.out.println("StringBuilder took: " + (end2 - start2) + "ms");
        // StringBuilder is typically orders of magnitude faster here, since
        // String concatenation in a loop creates a brand new String object
        // (and copies all previous characters) on EVERY single iteration.
    }
}
