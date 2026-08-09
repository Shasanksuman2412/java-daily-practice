import java.util.ArrayList;
import java.util.List;

public class WrapperClassesDemo {
    public static void main(String[] args) {

        // ---- Why wrapper classes exist: generics need objects ----
        List<Integer> numbers = new ArrayList<>(); // Integer, not int
        numbers.add(5);   // autoboxed: int 5 -> Integer automatically
        numbers.add(10);
        System.out.println("List of Integers: " + numbers);
        System.out.println("---");

        // ---- Useful wrapper methods ----
        int parsed = Integer.parseInt("42");
        System.out.println("Parsed \"42\" to int: " + parsed);
        System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
        System.out.println("10 in binary: " + Integer.toBinaryString(10));
        System.out.println("---");

        // ---- Autoboxing: primitive -> wrapper, automatically ----
        int x = 10;
        Integer boxed = x; // Java converts automatically
        System.out.println("Autoboxed int 10 to Integer: " + boxed);
        System.out.println("---");

        // ---- Unboxing: wrapper -> primitive, automatically ----
        Integer boxedValue = 50;
        int unboxed = boxedValue; // Java converts automatically
        System.out.println("Unboxed Integer 50 to int: " + unboxed);
        System.out.println("---");

        // ---- The Integer caching gotcha ----
        Integer a = 100;
        Integer b = 100;
        System.out.println("a == b for value 100 (within cache range -128 to 127)? " + (a == b)); // true

        Integer c = 200;
        Integer d = 200;
        System.out.println("c == d for value 200 (OUTSIDE cache range)? " + (c == d)); // false!

        System.out.println("c.equals(d) - correct way to compare: " + c.equals(d)); // true
        System.out.println("---");

        // ---- NullPointerException risk with unboxing ----
        Integer nullable = null;
        try {
            int crashes = nullable; // throws NullPointerException - can't unbox null
            System.out.println("This line never runs: " + crashes);
        } catch (NullPointerException e) {
            System.out.println("Caught NPE: cannot unbox a null Integer into int.");
        }
        System.out.println("---");

        // ---- Comparing and parsing ----
        System.out.println("Integer.compare(5, 10): " + Integer.compare(5, 10)); // negative
        System.out.println("Double.parseDouble(\"3.14\"): " + Double.parseDouble("3.14"));
        System.out.println("Boolean.parseBoolean(\"true\"): " + Boolean.parseBoolean("true"));
    }
}
