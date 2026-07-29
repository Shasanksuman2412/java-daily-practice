public class Book {

    // ---- Fields ----
    String title;
    String author;
    double price;
    int pages;

    // ---- Exercise 5: static field, shared across ALL Book objects ----
    static int totalBooksCreated = 0;

    // ---- Constructor ----
    Book(String title, String author, double price, int pages) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.pages = pages;
        totalBooksCreated++; // increments every time a new Book is made
    }

    // ---- Exercise 1: display info ----
    void displayInfo() {
        System.out.println("\"" + title + "\" by " + author +
                " - " + pages + " pages, ₹" + price);
    }

    // ---- Exercise 2: business logic method ----
    boolean isExpensive() {
        return price > 500;
    }
}
