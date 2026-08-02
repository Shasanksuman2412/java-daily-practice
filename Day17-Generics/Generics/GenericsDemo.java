import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {

    // ---- Generic method: works with ANY type ----
    public static <T> void printArray(T[] array) {
        for (T item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // ---- Bounded type parameter: T must be a Number (or subclass) ----
    public static <T extends Number> double sum(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static void main(String[] args) {

        // ---- Why generics matter: compile-time safety ----
        List<String> names = new ArrayList<>();
        names.add("Shasank");
        names.add("Priya");
        // names.add(42); // this line would NOT compile - uncomment to see the error
        System.out.println("Names: " + names);
        System.out.println("---");

        // ---- Generic class: Box<T> ----
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello Generics");
        System.out.println("stringBox contains: " + stringBox.get()); // no casting needed!

        Box<Integer> intBox = new Box<>();
        System.out.println("intBox empty before setting? " + intBox.isEmpty());
        intBox.set(42);
        System.out.println("intBox contains: " + intBox.get());
        System.out.println("intBox empty after setting? " + intBox.isEmpty());
        System.out.println("---");

        // ---- Generic method: works with different array types ----
        Integer[] nums = {1, 2, 3, 4};
        String[] words = {"java", "is", "fun"};
        System.out.print("Integer array: ");
        printArray(nums);
        System.out.print("String array: ");
        printArray(words);
        System.out.println("---");

        // ---- Multiple type parameters: Pair<K, V> ----
        Pair<String, Integer> agePair = new Pair<>("age", 21);
        Pair<String, String> namePair = new Pair<>("firstName", "Shasank");
        System.out.println("agePair: " + agePair);
        System.out.println("namePair: " + namePair);
        System.out.println("Key: " + agePair.getKey() + ", Value: " + agePair.getValue());
        System.out.println("---");

        // ---- Bounded type parameter in action ----
        System.out.println("sum(5, 10) = " + sum(5, 10));           // Integer
        System.out.println("sum(3.5, 2.1) = " + sum(3.5, 2.1));     // Double
        // sum("a", "b"); // this would NOT compile - String isn't a Number
    }
}
