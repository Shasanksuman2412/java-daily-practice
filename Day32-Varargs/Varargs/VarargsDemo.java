import java.util.List;

public class VarargsDemo {

    // ---- Basic varargs method ----
    static int sum(int... numbers) {
        int total = 0;
        for (int n : numbers) {
            total += n;
        }
        return total;
    }

    // ---- Varargs combined with a regular parameter (regular MUST come first) ----
    static void printAll(String prefix, int... numbers) {
        for (int n : numbers) {
            System.out.println(prefix + n);
        }
    }

    // ---- Overload resolution: specific match vs varargs ----
    static void greet(String name) {
        System.out.println("Specific overload called for: " + name);
    }

    static void greet(String... names) {
        System.out.println("Varargs overload called with " + names.length + " name(s)");
        for (String n : names) {
            System.out.println("- " + n);
        }
    }

    public static void main(String[] args) {

        // ---- Calling with different numbers of arguments ----
        System.out.println("sum() = " + sum());               // 0 - zero arguments is valid
        System.out.println("sum(5) = " + sum(5));
        System.out.println("sum(1, 2, 3) = " + sum(1, 2, 3));
        System.out.println("sum(1, 2, 3, 4, 5) = " + sum(1, 2, 3, 4, 5));
        System.out.println("---");

        // ---- Passing an actual array instead ----
        int[] values = {10, 20, 30};
        System.out.println("sum(values array) = " + sum(values)); // works the same way
        System.out.println("---");

        // ---- Varargs combined with a regular parameter ----
        printAll("Number: ", 1, 2, 3);
        System.out.println("---");

        // ---- Overload resolution ----
        greet("Shasank");                  // calls the SPECIFIC overload - closer match
        greet("Shasank", "Priya", "Amit"); // calls the VARARGS overload - only option that fits
        System.out.println("---");

        // ---- Practical built-in examples of varargs ----
        String formatted = String.format("Name: %s, Age: %d", "Shasank", 21);
        System.out.println(formatted);

        List<Integer> numbers = List.of(1, 2, 3, 4); // List.of() itself is varargs
        System.out.println("List.of() result: " + numbers);
    }
}
