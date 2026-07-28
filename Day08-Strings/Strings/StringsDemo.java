public class StringsDemo {
    public static void main(String[] args) {

        // ---- Strings are immutable ----
        String s = "hello";
        s.concat(" world"); // does NOT change s - result is discarded
        System.out.println("After concat without reassign: " + s); // still "hello"
        s = s.concat(" world"); // must reassign to capture the change
        System.out.println("After concat WITH reassign: " + s);
        System.out.println("---");

        // ---- Common String methods ----
        String text = "  Hello Java  ";
        System.out.println("Length: " + text.length());
        System.out.println("Trimmed: [" + text.trim() + "]");
        System.out.println("Uppercase: " + text.toUpperCase());
        System.out.println("Lowercase: " + text.toLowerCase());
        System.out.println("charAt(2): " + text.charAt(2));
        System.out.println("indexOf(\"Java\"): " + text.indexOf("Java"));
        System.out.println("substring(2, 7): " + text.substring(2, 7));
        System.out.println("---");

        // ---- equals() vs == ----
        String a = new String("hi");
        String b = new String("hi");
        System.out.println("a == b: " + (a == b));           // false - different objects in memory
        System.out.println("a.equals(b): " + a.equals(b));   // true - same content
        System.out.println("---");

        // ---- Concatenation vs StringBuilder ----
        // Fine for a small one-off case:
        String greeting = "Hello" + " " + "World";
        System.out.println(greeting);

        // Inefficient in a loop - creates a new String object every iteration:
        String inefficient = "";
        for (int i = 0; i < 5; i++) {
            inefficient += i + " ";
        }
        System.out.println("Built with += in a loop: " + inefficient);

        // Efficient way using StringBuilder:
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(i).append(" ");
        }
        String efficient = sb.toString();
        System.out.println("Built with StringBuilder: " + efficient);
        System.out.println("---");

        // ---- Splitting and joining ----
        String csv = "apple,banana,cherry";
        String[] fruits = csv.split(",");
        System.out.println("Split result:");
        for (String fruit : fruits) {
            System.out.println("- " + fruit);
        }

        String joined = String.join("-", fruits);
        System.out.println("Joined with '-': " + joined);
    }
}
