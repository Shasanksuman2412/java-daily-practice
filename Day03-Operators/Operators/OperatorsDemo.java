public class OperatorsDemo {
    public static void main(String[] args) {

        // ---- Arithmetic operators ----
        int a = 10, b = 3;
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));   // integer division -> 3
        System.out.println("a % b = " + (a % b));   // remainder -> 1

        // getting a real decimal result requires a double somewhere
        double preciseDivision = (double) a / b;
        System.out.println("a / b as double = " + preciseDivision); // 3.333...
        System.out.println("---");

        // ---- Relational operators (always return boolean) ----
        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));
        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("---");

        // ---- Logical operators ----
        boolean isRaining = true;
        boolean hasUmbrella = false;
        System.out.println("Raining AND has umbrella: " + (isRaining && hasUmbrella));
        System.out.println("Raining OR has umbrella: " + (isRaining || hasUmbrella));
        System.out.println("NOT raining: " + (!isRaining));
        System.out.println("---");

        // ---- Increment / Decrement: pre vs post ----
        int i = 5;
        System.out.println("i++ (post-increment) prints: " + (i++)); // prints 5
        System.out.println("i is now: " + i);                        // 6

        int j = 5;
        System.out.println("++j (pre-increment) prints: " + (++j));  // prints 6
        System.out.println("j is now: " + j);                        // 6
        System.out.println("---");

        // ---- Compound assignment operators ----
        int x = 10;
        x += 5;  // x = x + 5
        System.out.println("x += 5 -> " + x); // 15
        x -= 2;
        System.out.println("x -= 2 -> " + x); // 13
        x *= 3;
        System.out.println("x *= 3 -> " + x); // 39
        x /= 4;
        System.out.println("x /= 4 -> " + x); // 9 (integer division)
    }
}
