import java.util.List;

public class LibraryManagementSystem {
    public static void main(String[] args) {

        // ---- Singleton: get the one and only Library instance ----
        Library library = Library.getInstance();
        library.loadFromFile();
        System.out.println("---");

        // ---- Adding books using the Builder pattern ----
        library.addBook(new Book.Builder("The Hobbit", "J.R.R. Tolkien", "ISBN001").build());
        library.addBook(new Book.Builder("1984", "George Orwell", "ISBN002").build());
        library.addBook(new Book.Builder("Dune", "Frank Herbert", "ISBN003").build());
        library.addBook(new Book.Builder("Brave New World", "Aldous Huxley", "ISBN004").build());
        System.out.println("---");

        // ---- Borrowing a book, handling custom exceptions ----
        try {
            library.borrowBook("ISBN002");
            library.borrowBook("ISBN002"); // trying to borrow an already-borrowed book
        } catch (BookNotFoundException | BookNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("---");

        // ---- Trying to borrow a book that doesn't exist ----
        try {
            library.borrowBook("ISBN999");
        } catch (BookNotFoundException | BookNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("---");

        // ---- Returning a book ----
        try {
            library.returnBook("ISBN002");
        } catch (BookNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("---");

        // ---- Sorting: Comparable (by title) ----
        System.out.println("All books sorted by title:");
        library.displayAllSortedByTitle();
        System.out.println("---");

        // ---- Sorting: Comparator (by author) ----
        System.out.println("All books sorted by author:");
        library.displayAllSortedByAuthor();
        System.out.println("---");

        // ---- Searching with streams ----
        List<Book> searchResults = library.searchByTitleContains("the");
        System.out.println("Books with 'the' in the title:");
        searchResults.forEach(System.out::println);
        System.out.println("---");

        // ---- Report using streams ----
        library.printSummaryReport();
        System.out.println("---");

        // ---- Singleton proof ----
        Library sameLibrary = Library.getInstance();
        System.out.println("library == sameLibrary (Singleton confirmed)? " + (library == sameLibrary));
        System.out.println("---");

        // ---- Save everything for next time ----
        library.saveToFile();
    }
}
