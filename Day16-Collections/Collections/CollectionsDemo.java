import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class CollectionsDemo {
    public static void main(String[] args) {

        // ---- List: ordered, allows duplicates ----
        List<String> names = new ArrayList<>();
        names.add("Shasank");
        names.add("Priya");
        names.add("Shasank"); // duplicates ARE allowed
        System.out.println("List: " + names);
        System.out.println("First element: " + names.get(0));
        System.out.println("---");

        // ---- Set: no duplicates ----
        Set<String> uniqueNames = new HashSet<>();
        uniqueNames.add("Shasank");
        uniqueNames.add("Priya");
        uniqueNames.add("Shasank"); // ignored silently, already exists
        System.out.println("Set: " + uniqueNames);
        System.out.println("Set size: " + uniqueNames.size()); // 2, not 3
        System.out.println("---");

        // ---- Map: key-value pairs ----
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Shasank", 21);
        ages.put("Priya", 22);
        ages.put("Shasank", 25); // overwrites the previous value for this key
        System.out.println("Map: " + ages);
        System.out.println("Shasank's age: " + ages.get("Shasank"));
        System.out.println("Contains key 'Priya'? " + ages.containsKey("Priya"));
        System.out.println("---");

        // ---- Iterating over a List ----
        System.out.println("Iterating List:");
        for (String name : names) {
            System.out.println("- " + name);
        }
        System.out.println("---");

        // ---- Iterating over a Map ----
        System.out.println("Iterating Map:");
        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println("---");

        // ---- Collections utility class ----
        List<Integer> numbers = new ArrayList<>();
        numbers.add(45);
        numbers.add(12);
        numbers.add(78);
        numbers.add(3);

        System.out.println("Before sort: " + numbers);
        Collections.sort(numbers);
        System.out.println("After sort: " + numbers);
        Collections.reverse(numbers);
        System.out.println("After reverse: " + numbers);
        System.out.println("Max: " + Collections.max(numbers));
        System.out.println("Min: " + Collections.min(numbers));
    }
}
