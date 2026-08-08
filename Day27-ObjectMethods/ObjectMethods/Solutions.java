import java.util.HashSet;
import java.util.Set;

public class Solutions {
    public static void main(String[] args) {

        // ---- Exercise 1: toString() ----
        Book b1 = new Book("1984", "George Orwell", 1949);
        Book b2 = new Book("1984", "George Orwell", 2003); // same title/author, different year
        System.out.println(b1);
        System.out.println(b2);
        System.out.println("---");

        // ---- Exercise 2: equals() ignoring year ----
        System.out.println("b1.equals(b2) (same title/author, different year)? " + b1.equals(b2));
        System.out.println("---");

        // ---- Exercise 3: hashCode() matching equals(), HashSet dedup ----
        Set<Book> books = new HashSet<>();
        books.add(new Book("1984", "George Orwell", 1949));
        books.add(new Book("1984", "George Orwell", 2003)); // duplicate by title+author
        books.add(new Book("Brave New World", "Aldous Huxley", 1932));
        System.out.println("HashSet<Book> size (should be 2, duplicate removed): " + books.size());
        System.out.println("---");

        // ---- Exercise 4: broken hashCode/equals contract ----
        Set<BadBook> badBooks = new HashSet<>();
        badBooks.add(new BadBook("1984", "George Orwell"));
        badBooks.add(new BadBook("1984", "George Orwell")); // "duplicate" by data
        System.out.println("HashSet<BadBook> size (BROKEN - should be 1 but isn't): " + badBooks.size());
        // prints 2 - because hashCode() wasn't overridden, HashSet never even
        // checks equals() for objects that land in different hash "buckets"
        System.out.println("---");

        // ---- Exercise 5: equals() with inheritance pitfalls ----
        Book plainBook = new Book("Dune", "Frank Herbert", 1965);
        Ebook ebookVersion = new Ebook("Dune", "Frank Herbert", 1965, 4.2);

        boolean areEqual = plainBook.equals(ebookVersion);
        System.out.println("plainBook.equals(ebookVersion) despite same title/author? " + areEqual);
        // false - because getClass() != obj.getClass() : Book.class != Ebook.class,
        // even though Ebook IS-A Book through inheritance. This is a known trade-off:
        // using getClass() makes equals() strict about exact type, which avoids
        // asymmetric equals() bugs, but means subclasses are NEVER equal to their parent type.
    }
}
