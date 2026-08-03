import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Solutions {
    public static void main(String[] args) {

        // ---- Exercise 1: Custom functional interface ----
        Calculator add = (a, b) -> a + b;
        Calculator subtract = (a, b) -> a - b;
        Calculator multiply = (a, b) -> a * b;

        System.out.println("add.operate(10, 5) = " + add.operate(10, 5));
        System.out.println("subtract.operate(10, 5) = " + subtract.operate(10, 5));
        System.out.println("multiply.operate(10, 5) = " + multiply.operate(10, 5));
        System.out.println("---");

        // ---- Exercise 2: Filter and collect names ----
        List<String> names = List.of("Shasank", "Amit", "Priya", "Al", "Neha", "Bo");
        List<String> longNames = names.stream()
                .filter(name -> name.length() > 3)
                .collect(Collectors.toList());
        System.out.println("Names longer than 3 characters: " + longNames);
        System.out.println("---");

        // ---- Exercise 3: Transform and sum with streams ----
        List<Integer> prices = List.of(100, 250, 75, 300, 50);
        double discountedTotal = prices.stream()
                .filter(price -> price > 100)
                .mapToDouble(price -> price * 0.9) // apply 10% discount
                .sum();
        System.out.println("Discounted total (prices > 100): " + discountedTotal);
        System.out.println("---");

        // ---- Exercise 4: Sort custom objects using a lambda Comparator ----
        List<Student> students = new ArrayList<>();
        students.add(new Student("Shasank", 85));
        students.add(new Student("Priya", 92));
        students.add(new Student("Amit", 78));
        students.add(new Student("Neha", 88));

        students.sort((a, b) -> b.marks - a.marks); // descending order by marks

        System.out.println("Students sorted by marks (highest first):");
        for (Student s : students) {
            System.out.println(s.name + ": " + s.marks);
        }
        System.out.println("---");

        // ---- Exercise 5: Word length statistics using streams ----
        List<String> words = List.of("java", "is", "a", "powerful", "programming", "language");

        String longestWord = words.stream()
                .max((a, b) -> a.length() - b.length())
                .orElse("");
        System.out.println("Longest word: " + longestWord);

        double averageLength = words.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0);
        System.out.println("Average word length: " + averageLength);

        List<String> longWords = words.stream()
                .filter(word -> word.length() > 5)
                .collect(Collectors.toList());
        System.out.println("Words longer than 5 characters: " + longWords);
    }
}
