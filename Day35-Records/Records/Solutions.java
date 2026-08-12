import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Solutions {
    public static void main(String[] args) {

        // ---- Exercise 1: Create Movie records ----
        Movie m1 = new Movie("Inception", "Christopher Nolan", 2010, 8.8);
        Movie m2 = new Movie("The Room", "Tommy Wiseau", 2003, 3.7);
        Movie m3 = new Movie("Inception", "Christopher Nolan", 2010, 8.8); // same data as m1

        System.out.println(m1);
        System.out.println(m2);
        System.out.println("m1.equals(m3) (same data)? " + m1.equals(m3));
        System.out.println("---");

        // ---- Exercise 2: Compact constructor validation ----
        try {
            Movie invalid = new Movie("Bad Movie", "Nobody", 2020, 15.0); // invalid rating
            System.out.println(invalid);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        System.out.println("---");

        // ---- Exercise 3: Filter highly-rated movies with streams ----
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Inception", "Christopher Nolan", 2010, 8.8));
        movies.add(new Movie("The Room", "Tommy Wiseau", 2003, 3.7));
        movies.add(new Movie("Interstellar", "Christopher Nolan", 2014, 8.6));
        movies.add(new Movie("Cats", "Tom Hooper", 2019, 2.8));

        System.out.println("Highly rated movies:");
        movies.stream()
                .filter(Movie::isHighlyRated)
                .forEach(System.out::println);
        System.out.println("---");

        // ---- Exercise 4: Sort by rating descending using Comparable ----
        Collections.sort(movies);
        System.out.println("All movies sorted by rating (highest first):");
        for (Movie m : movies) {
            System.out.println(m);
        }
        System.out.println("---");

        // ---- Exercise 5: Record vs class comparison ----
        StudentRecord student = new StudentRecord("Shasank", 21);
        System.out.println("StudentRecord: " + student);
        System.out.println("Name: " + student.name() + ", Age: " + student.age());
        // The record version is 1 line, vs Day 27's Student.java which was
        // roughly 30 lines including the manual equals/hashCode/toString.
        // The trade-off: a record can NEVER add a setAge() method later,
        // since immutability isn't optional for records - it's fundamental.
    }
}
