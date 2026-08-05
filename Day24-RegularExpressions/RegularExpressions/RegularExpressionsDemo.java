import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegularExpressionsDemo {
    public static void main(String[] args) {

        // ---- Basic matching ----
        String text = "Hello123";
        boolean matches = text.matches("[a-zA-Z]+\\d+"); // letters followed by digits
        System.out.println("\"Hello123\" matches letters+digits? " + matches);
        System.out.println("---");

        // ---- Validating an email ----
        String validEmail = "shasank@example.com";
        String invalidEmail = "not-an-email";
        String emailPattern = "^[\\w.]+@[\\w]+\\.[a-z]{2,}$";
        System.out.println(validEmail + " is valid? " + validEmail.matches(emailPattern));
        System.out.println(invalidEmail + " is valid? " + invalidEmail.matches(emailPattern));
        System.out.println("---");

        // ---- Validating a phone number pattern ----
        String phone = "123-456-7890";
        boolean validPhone = phone.matches("\\d{3}-\\d{3}-\\d{4}");
        System.out.println(phone + " is a valid phone format? " + validPhone);
        System.out.println("---");

        // ---- Pattern and Matcher: finding all matches ----
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher("I have 5 apples and 12 oranges, total 17");
        System.out.println("Finding all numbers in the sentence:");
        while (matcher.find()) {
            System.out.println("Found: " + matcher.group());
        }
        System.out.println("---");

        // ---- Replacing text with regex ----
        String contactInfo = "Contact: 123-456-7890 or 987-654-3210";
        String masked = contactInfo.replaceAll("\\d{3}-\\d{3}-\\d{4}", "XXX-XXX-XXXX");
        System.out.println("Original: " + contactInfo);
        System.out.println("Masked: " + masked);
        System.out.println("---");

        // ---- Splitting with regex ----
        String data = "apple, banana,  cherry ,date";
        String[] items = data.split("\\s*,\\s*"); // splits on comma, trims surrounding spaces
        System.out.println("Split items:");
        for (String item : items) {
            System.out.println("[" + item + "]");
        }
    }
}
