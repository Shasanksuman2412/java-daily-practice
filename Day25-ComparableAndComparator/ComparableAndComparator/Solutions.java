import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Solutions {
    public static void main(String[] args) {

        // ---- Exercise 1: Product implementing Comparable ----
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 55000));
        products.add(new Product("Mouse", 500));
        products.add(new Product("Keyboard", 1500));
        products.add(new Product("Monitor", 12000));

        Collections.sort(products); // uses Product's compareTo() - by price ascending
        System.out.println("Sorted by natural order (price ascending):");
        for (Product p : products) System.out.println(p);
        System.out.println("---");

        // ---- Exercise 2: Sort the same list multiple ways with Comparator lambdas ----
        products.sort((a, b) -> a.name.compareTo(b.name));
        System.out.println("Sorted by name:");
        for (Product p : products) System.out.println(p);

        products.sort((a, b) -> Double.compare(b.price, a.price));
        System.out.println("Sorted by price descending:");
        for (Product p : products) System.out.println(p);

        products.sort((a, b) -> a.name.length() - b.name.length());
        System.out.println("Sorted by name length (shortest first):");
        for (Product p : products) System.out.println(p);
        System.out.println("---");

        // ---- Exercise 3: Comparator.comparing().reversed() ----
        products.sort(Comparator.comparing((Product p) -> p.price).reversed());
        System.out.println("Sorted by price descending, using Comparator.comparing().reversed():");
        for (Product p : products) System.out.println(p);
        System.out.println("---");

        // ---- Exercise 4: Chained comparator with a tie-breaker ----
        List<Product> withTies = new ArrayList<>();
        withTies.add(new Product("Zebra Item", 999));
        withTies.add(new Product("Apple Item", 999)); // same price, different name
        withTies.add(new Product("Mango Item", 500));

        withTies.sort(
            Comparator.comparing((Product p) -> p.price)
                      .thenComparing(p -> p.name)
        );
        System.out.println("Sorted by price, ties broken by name:");
        for (Product p : withTies) System.out.println(p);
        System.out.println("---");

        // ---- Exercise 5: Sort a List of Lists by size ----
        List<List<Integer>> groups = new ArrayList<>();
        groups.add(List.of(5, 2, 8));
        groups.add(List.of(1));
        groups.add(List.of(3, 3, 3, 3));

        groups.sort(Comparator.comparingInt(List::size));
        System.out.println("Groups sorted by size (smallest first):");
        for (List<Integer> g : groups) System.out.println(g);
    }
}
