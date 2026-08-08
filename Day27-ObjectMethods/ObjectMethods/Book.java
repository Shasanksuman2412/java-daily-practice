import java.util.Objects;

public class Book {
    String title;
    String author;
    int year;

    Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + year + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book other = (Book) obj;
        return title.equals(other.title) && author.equals(other.author); // year deliberately excluded
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author); // must match the SAME fields used in equals()
    }
}
