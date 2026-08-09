import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Comparator;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Library {
    private static Library instance; // Singleton instance
    private List<Book> books = new ArrayList<>();
    private static final String FILE_NAME = "library.txt";

    private Library() {
    } // private constructor - only getInstance() can create this

    public static synchronized Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added: " + book);
    }

    public Optional<Book> findByIsbn(String isbn) {
        return books.stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst();
    }

    public void borrowBook(String isbn) throws BookNotFoundException, BookNotAvailableException {
        Book book = findByIsbn(isbn)
                .orElseThrow(() -> new BookNotFoundException("No book found with ISBN: " + isbn));

        if (book.getStatus() != BookStatus.AVAILABLE) {
            throw new BookNotAvailableException(
                    "\"" + book.getTitle() + "\" is currently " + book.getStatus() + ", cannot borrow.");
        }
        book.setStatus(BookStatus.BORROWED);
        System.out.println("Borrowed: " + book);
    }

    public void returnBook(String isbn) throws BookNotFoundException {
        Book book = findByIsbn(isbn)
                .orElseThrow(() -> new BookNotFoundException("No book found with ISBN: " + isbn));
        book.setStatus(BookStatus.AVAILABLE);
        System.out.println("Returned: " + book);
    }

    public List<Book> searchByTitleContains(String keyword) {
        return books.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
    }

    public void displayAllSortedByTitle() {
        List<Book> sorted = new ArrayList<>(books);
        java.util.Collections.sort(sorted); // uses Book's Comparable (by title)
        sorted.forEach(System.out::println);
    }

    public void displayAllSortedByAuthor() {
        List<Book> sorted = new ArrayList<>(books);
        sorted.sort(Comparator.comparing(Book::getAuthor));
        sorted.forEach(System.out::println);
    }

    public long countByStatus(BookStatus status) {
        return books.stream()
                .filter(b -> b.getStatus() == status)
                .count();
    }

    public void printSummaryReport() {
        System.out.println("Total books: " + books.size());
        for (BookStatus status : BookStatus.values()) {
            System.out.println(status + ": " + countByStatus(status));
        }
    }

    public void saveToFile() {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            for (Book b : books) {
                writer.write(b.toFileFormat() + "\n");
            }
            System.out.println("Saved " + books.size() + " books to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error saving library: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No saved library file found - starting fresh.");
            return;
        }
        books.clear();
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.isBlank()) continue;
                books.add(Book.fromFileFormat(line));
            }
            System.out.println("Loaded " + books.size() + " books from " + FILE_NAME);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
