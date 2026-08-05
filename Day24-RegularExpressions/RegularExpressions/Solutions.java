import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Solutions {

    // ---- Exercise 1: Password strength checker ----
    static boolean isStrongPassword(String password) {
        boolean longEnough = password.length() >= 8;
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasUppercase = password.matches(".*[A-Z].*");
        return longEnough && hasDigit && hasUppercase;
    }

    // ---- Exercise 3: Validate an Indian PIN code ----
    static boolean isValidPinCode(String code) {
        return code.matches("\\d{6}");
    }

    public static void main(String[] args) {

        // ---- Exercise 1 ----
        System.out.println("\"Password1\" is strong? " + isStrongPassword("Password1"));
        System.out.println("\"weak\" is strong? " + isStrongPassword("weak"));
        System.out.println("---");

        // ---- Exercise 2: Extract all email addresses ----
        String text = "Contact us at support@example.com or sales@company.org for help.";
        Pattern emailPattern = Pattern.compile("[\\w.]+@[\\w]+\\.[a-z]{2,}");
        Matcher emailMatcher = emailPattern.matcher(text);
        System.out.println("Emails found:");
        while (emailMatcher.find()) {
            System.out.println("- " + emailMatcher.group());
        }
        System.out.println("---");

        // ---- Exercise 3 ----
        System.out.println("\"400001\" valid PIN? " + isValidPinCode("400001"));
        System.out.println("\"4000A1\" valid PIN? " + isValidPinCode("4000A1"));
        System.out.println("---");

        // ---- Exercise 4: Remove all extra whitespace ----
        String messy = "This   has     way    too much   spacing.";
        String cleaned = messy.replaceAll("\\s+", " "); // one-or-more spaces -> single space
        System.out.println("Before: " + messy);
        System.out.println("After: " + cleaned);
        System.out.println("---");

        // ---- Exercise 5: Extract and sum all numbers ----
        String sentence = "I bought 3 apples, 12 bananas, and 7 mangoes for a total of 22 fruits.";
        Pattern numberPattern = Pattern.compile("\\d+");
        Matcher numberMatcher = numberPattern.matcher(sentence);
        int sum = 0;
        System.out.println("Numbers found:");
        while (numberMatcher.find()) {
            int num = Integer.parseInt(numberMatcher.group());
            System.out.println("- " + num);
            sum += num;
        }
        System.out.println("Sum of all numbers: " + sum);
    }
}
