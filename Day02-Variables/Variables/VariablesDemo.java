public class VariablesDemo {
    public static void main(String[] args) {

        // ---- Primitive data types ----
        byte smallNumber = 100;              // 1 byte, range -128 to 127
        short mediumNumber = 30000;          // 2 bytes
        int age = 21;                        // 4 bytes, most commonly used
        long population = 8000000000L;       // 8 bytes, note the 'L' suffix
        float price = 199.99f;                // 4 bytes, note the 'f' suffix
        double pi = 3.14159265;              // 8 bytes, default for decimals
        char grade = 'A';                    // single character, 2 bytes
        boolean isJavaFun = true;            // true/false only

        // ---- Reference type ----
        String name = "Shasank";             // String is an object, not a primitive

        // ---- Printing values ----
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Population: " + population);
        System.out.println("Price: " + price);
        System.out.println("Pi: " + pi);
        System.out.println("Grade: " + grade);
        System.out.println("Is Java fun? " + isJavaFun);

        // ---- final (constant) ----
        final double GST_RATE = 0.18; // cannot be reassigned after this
        double priceWithTax = price + (price * GST_RATE);
        System.out.println("Price with GST: " + priceWithTax);

        // ---- Type casting ----
        double decimalValue = 9.7;
        int wholeValue = (int) decimalValue;  // narrowing cast: 9.7 -> 9 (decimal dropped, not rounded)
        System.out.println("Decimal 9.7 cast to int: " + wholeValue);

        int wholeNum = 10;
        double widenedValue = wholeNum;       // widening: happens automatically, no cast needed
        System.out.println("int 10 widened to double: " + widenedValue);
    }
}
