import java.util.Iterator;
import java.util.NoSuchElementException;

public class Solutions {
    public static void main(String[] args) {

        // ---- Exercise 1: basic Range iteration ----
        System.out.print("Range(1, 5): ");
        for (int n : new Range(1, 5)) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("---");

        // ---- Exercise 2: step-based Range ----
        System.out.print("Range(0, 10, 2): ");
        for (int n : new Range(0, 10, 2)) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("---");

        // ---- Exercise 3: NumberCollection normal vs even-only iteration ----
        NumberCollection numbers = new NumberCollection(new int[]{3, 8, 15, 22, 7, 4});

        System.out.print("All numbers: ");
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();

        System.out.print("Even only: ");
        Iterator<Integer> evenIt = numbers.evenOnlyIterator();
        while (evenIt.hasNext()) {
            System.out.print(evenIt.next() + " ");
        }
        System.out.println();
        System.out.println("---");

        // ---- Exercise 4: two independent iterators on the same Range ----
        Range range = new Range(1, 5);
        Iterator<Integer> iteratorA = range.iterator();
        Iterator<Integer> iteratorB = range.iterator(); // a SEPARATE, fresh iterator

        System.out.println("iteratorA.next(): " + iteratorA.next()); // 1
        System.out.println("iteratorA.next(): " + iteratorA.next()); // 2
        System.out.println("iteratorB.next(): " + iteratorB.next()); // 1 - independent position!
        System.out.println("iteratorA and B are tracking SEPARATE positions.");
        System.out.println("---");

        // ---- Exercise 5: deliberately exhausting an iterator ----
        Iterator<Integer> smallRange = new Range(1, 2).iterator();
        try {
            smallRange.next(); // 1
            smallRange.next(); // 2
            smallRange.next(); // should throw - no more elements
        } catch (NoSuchElementException e) {
            System.out.println("Caught expected exception: iterator was exhausted.");
        }
    }
}
