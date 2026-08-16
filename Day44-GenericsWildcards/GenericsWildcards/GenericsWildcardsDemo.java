import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class GenericsWildcardsDemo {

    // ---- ? extends: producer, read-only, accepts T or any subtype ----
    static double sumOfList(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) { // safe to READ as Number
            sum += n.doubleValue();
        }
        return sum;
        // list.add(5); // this would NOT compile - can't safely ADD to an "extends" list
    }

    // ---- ? super: consumer, write-only, accepts T or any supertype ----
    static void addNumbers(List<? super Integer> list) {
        list.add(1); // safe to ADD Integers
        list.add(2);
        list.add(3);
        // Number n = list.get(0); // this would NOT compile as Number - only Object is guaranteed
    }

    // ---- Unbounded wildcard: don't care about the type at all ----
    static void printSize(List<?> list) {
        System.out.println("Size: " + list.size()); // fine - size() is type-independent
    }

    // ---- PECS in a real method: copying from a producer into a consumer ----
    static <T> void copyAll(List<? super T> dest, List<? extends T> src) {
        for (T item : src) { // reading from src - producer, extends
            dest.add(item);   // writing into dest - consumer, super
        }
    }

    public static void main(String[] args) {

        // ---- The problem: List<Integer> is NOT a List<Number> ----
        List<Integer> integers = List.of(1, 2, 3);
        // List<Number> numbers = integers; // this line would NOT compile!
        System.out.println("List<Integer> cannot be directly assigned to List<Number>.");
        System.out.println("---");

        // ---- ? extends Number: works with List<Integer> AND List<Double> ----
        List<Integer> intList = List.of(1, 2, 3);
        List<Double> doubleList = List.of(1.5, 2.5, 3.0);

        System.out.println("Sum of intList: " + sumOfList(intList));
        System.out.println("Sum of doubleList: " + sumOfList(doubleList));
        System.out.println("---");

        // ---- ? super Integer: works with List<Integer>, List<Number>, List<Object> ----
        List<Integer> targetInt = new ArrayList<>();
        List<Number> targetNumber = new ArrayList<>();
        List<Object> targetObject = new ArrayList<>();

        addNumbers(targetInt);
        addNumbers(targetNumber);
        addNumbers(targetObject);

        System.out.println("targetInt after addNumbers: " + targetInt);
        System.out.println("targetNumber after addNumbers: " + targetNumber);
        System.out.println("targetObject after addNumbers: " + targetObject);
        System.out.println("---");

        // ---- Unbounded wildcard ----
        printSize(intList);
        printSize(List.of("a", "b", "c", "d"));
        System.out.println("---");

        // ---- PECS in action: copying between differently-typed lists ----
        List<Integer> source = List.of(10, 20, 30);
        List<Number> destination = new ArrayList<>();
        copyAll(destination, source); // dest is Number (super Integer), src is Integer (extends Integer)
        System.out.println("Copied into destination: " + destination);

        // ---- Java's real Collections.copy() uses this exact pattern ----
        List<Number> realDest = new ArrayList<>(List.of(0, 0, 0));
        List<Integer> realSrc = List.of(100, 200, 300);
        Collections.copy(realDest, realSrc); // dest: ? super T, src: ? extends T
        System.out.println("Collections.copy() result: " + realDest);
    }
}
