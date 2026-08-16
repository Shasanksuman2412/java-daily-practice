import java.util.List;
import java.util.ArrayList;

public class Solutions {

    // ---- Exercise 1: ? extends for reading numeric values ----
    static double average(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum / list.size();
    }

    // ---- Exercise 2: ? super for adding Integers into a broader list ----
    static void fillWithZeros(List<? super Integer> list, int count) {
        for (int i = 0; i < count; i++) {
            list.add(0);
        }
    }

    // ---- Exercise 3: PECS applied to a filtered copy method ----
    static <T> void copyMatching(List<? extends T> src, List<? super T> dest, T filterValue) {
        for (T item : src) { // reading from src - producer, extends
            if (item.equals(filterValue)) {
                dest.add(item); // writing into dest - consumer, super
            }
        }
    }

    // ---- Exercise 4: FIXED version - can't safely add to "? extends Number" ----
    // The original `list.add(5)` fails because list could secretly be a
    // List<Double> - adding an Integer into that would silently corrupt it.
    // Fix: use a specific type instead of a wildcard when you need to ADD.
    static void addFiveFixed(List<Integer> list) {
        list.add(5); // works now, because the type is known EXACTLY, no wildcard risk
    }

    // ---- Exercise 5: bounded wildcard max finder ----
    // <T extends Comparable<? super T>> - T must be comparable to itself OR
    // any of its supertypes. This is more flexible than <T extends Comparable<T>>
    // because it also allows types where the compareTo() is defined on a PARENT
    // class rather than the exact type T itself.
    // List<? extends T> - src just needs to PRODUCE values assignable to T.
    static <T extends Comparable<? super T>> T findMax(List<? extends T> list) {
        T max = list.get(0);
        for (T item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        // ---- Exercise 1 ----
        List<Integer> intList = List.of(10, 20, 30);
        List<Double> doubleList = List.of(1.5, 2.5, 3.5);
        System.out.println("Average of intList: " + average(intList));
        System.out.println("Average of doubleList: " + average(doubleList));
        System.out.println("---");

        // ---- Exercise 2 ----
        List<Integer> targetInt = new ArrayList<>();
        List<Number> targetNumber = new ArrayList<>();
        List<Object> targetObject = new ArrayList<>();
        fillWithZeros(targetInt, 3);
        fillWithZeros(targetNumber, 2);
        fillWithZeros(targetObject, 4);
        System.out.println("targetInt: " + targetInt);
        System.out.println("targetNumber: " + targetNumber);
        System.out.println("targetObject: " + targetObject);
        System.out.println("---");

        // ---- Exercise 3 ----
        List<String> source = List.of("apple", "banana", "apple", "cherry");
        List<Object> destination = new ArrayList<>();
        copyMatching(source, destination, "apple");
        System.out.println("Copied matching 'apple': " + destination);
        System.out.println("---");

        // ---- Exercise 4 ----
        List<Integer> fixedList = new ArrayList<>();
        addFiveFixed(fixedList);
        System.out.println("After addFiveFixed: " + fixedList);
        System.out.println("---");

        // ---- Exercise 5 ----
        List<Integer> numbers = List.of(45, 89, 23, 67);
        List<String> words = List.of("banana", "apple", "cherry");
        System.out.println("Max number: " + findMax(numbers));
        System.out.println("Max word (alphabetically): " + findMax(words));
    }
}
