import java.util.Objects;

public class Book implements Comparable<Book> {
    private final String title;
    private final String author;
    private final String isbn;
    private BookStatus status;

    private Book(Builder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.isbn = builder.isbn;
        this.status = BookStatus.AVAILABLE; // every new book starts available
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    // ---- Natural sort order: by title ----
    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }

    // ---- Two books are the "same book" if their ISBN matches ----
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book other = (Book) obj;
        return isbn.equals(other.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + " [ISBN: " + isbn + "] - " + status;
    }

    // ---- File persistence helpers ----
    public String toFileFormat() {
        return isbn + "," + title + "," + author + "," + status;
    }

    public static Book fromFileFormat(String line) {
        String[] parts = line.split(",");
        Book book = new Book.Builder(parts[1], parts[2], parts[0]).build();
        book.setStatus(BookStatus.valueOf(parts[3]));
        return book;
    }

    // ---- Builder pattern ----
    public static class Builder {
        private final String title;
        private final String author;
        private final String isbn;

        public Builder(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
        }

        public Book build() {
            if (title == null || title.isEmpty() || isbn == null || isbn.isEmpty()) {
                throw new IllegalStateException("Book must have a title and ISBN.");
            }
            return new Book(this);
        }
    }
}
