import java.util.List;

public class Solutions {

    // ---- Exercise 3: Safe unboxing with a null check ----
    static int safeUnbox(Integer value, int defaultValue) {
        if (value != null) {
            return value; // safe to unbox here, we KNOW it's not null
        }
        return defaultValue;
    }

    public static void main(String[] args) {

        // ---- Exercise 1: Parse and sum Strings ----
        List<String> numberStrings = List.of("10", "25", "7", "42");
        int sum = 0;
        for (String s : numberStrings) {
            sum += Integer.parseInt(s);
        }
        System.out.println("Sum of parsed numbers: " + sum);
        System.out.println("---");

        // ---- Exercise 2: Prove the Integer cache gotcha ----
        Integer a = 50;
        Integer b = 50;
        System.out.println("a == b for value 50 (WITHIN cache range -128 to 127): " + (a == b));
        // true - both point to the SAME cached Integer object

        Integer c = 150;
        Integer d = 150;
        System.out.println("c == d for value 150 (OUTSIDE cache range): " + (c == d));
        // false - 150 is outside the cached range, so each autoboxing creates a NEW object
        System.out.println("---");

        // ---- Exercise 3: Safe unboxing ----
        Integer presentValue = 42;
        Integer missingValue = null;
        System.out.println("safeUnbox(42, -1): " + safeUnbox(presentValue, -1));
        System.out.println("safeUnbox(null, -1): " + safeUnbox(missingValue, -1));
        System.out.println("---");

        // ---- Exercise 4: Wrapper class utility methods ----
        double parsedDouble = Double.parseDouble("3.14159");
        String hex = Integer.toHexString(255);
        int maxOfTwo = Integer.max(45, 89);
        boolean isDigit = Character.isDigit('7');

        System.out.println("Parsed double: " + parsedDouble);
        System.out.println("255 in hex: " + hex);
        System.out.println("Max of 45 and 89: " + maxOfTwo);
        System.out.println("Is '7' a digit? " + isDigit);
        System.out.println("---");

        // ---- Exercise 5: Autoboxing performance pitfall ----
        long start1 = System.currentTimeMillis();
        Integer boxedSum = 0;
        for (int i = 1; i <= 100000; i++) {
            boxedSum += i; // unboxes, adds, reboxes EVERY single iteration
        }
        long end1 = System.currentTimeMillis();
        System.out.println("Integer sum: " + boxedSum + ", took " + (end1 - start1) + "ms");

        long start2 = System.currentTimeMillis();
        int primitiveSum = 0;
        for (int i = 1; i <= 100000; i++) {
            primitiveSum += i; // stays a primitive the whole time, no boxing overhead
        }
        long end2 = System.currentTimeMillis();
        System.out.println("int sum: " + primitiveSum + ", took " + (end2 - start2) + "ms");
        // the int version is typically faster (or at least never slower) due to
        // avoiding repeated boxing/unboxing overhead on every loop iteration
    }
}
