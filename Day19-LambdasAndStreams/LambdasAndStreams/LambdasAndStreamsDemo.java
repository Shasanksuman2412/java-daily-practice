import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class LambdasAndStreamsDemo {
    public static void main(String[] args) {

        // ---- Old way vs lambda way ----
        Runnable oldWay = new Runnable() {
            public void run() {
                System.out.println("Running the old anonymous class way!");
            }
        };
        Runnable newWay = () -> System.out.println("Running the lambda way!");
        oldWay.run();
        newWay.run();
        System.out.println("---");

        // ---- Custom functional interface with a lambda ----
        Greet g = (name) -> System.out.println("Hello, " + name);
        g.sayHello("Shasank");
        System.out.println("---");

        // ---- Built-in functional interfaces ----
        Function<Integer, Integer> square = x -> x * x;
        System.out.println("square.apply(5) = " + square.apply(5));

        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println("isEven.test(4) = " + isEven.test(4));
        System.out.println("isEven.test(7) = " + isEven.test(7));

        Consumer<String> printer = s -> System.out.println("Value: " + s);
        printer.accept("hello lambda");
        System.out.println("---");

        // ---- Streams: filter, map, collect ----
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenSquares = numbers.stream()
                .filter(n -> n % 2 == 0)       // keep only even numbers
                .map(n -> n * n)                // square each one
                .collect(Collectors.toList());  // gather into a new List

        System.out.println("Even squares: " + evenSquares);
        System.out.println("---");

        // ---- Common stream operations ----
        long countAbove5 = numbers.stream().filter(n -> n > 5).count();
        System.out.println("Count above 5: " + countAbove5);

        boolean anyAbove8 = numbers.stream().anyMatch(n -> n > 8);
        System.out.println("Any number above 8? " + anyAbove8);

        System.out.print("Sorted descending: ");
        numbers.stream()
                .sorted((a, b) -> b - a) // descending order
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Sum of all numbers: " + sum);

        // ---- Method reference: :: shorthand for a lambda calling an existing method ----
        System.out.println("Using method reference to print each number:");
        numbers.stream().forEach(System.out::println);
    }
}
