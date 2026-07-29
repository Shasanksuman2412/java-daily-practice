public class Solutions {
    public static void main(String[] args) {

        // ---- Exercise 1 & 2: Book class ----
        Book b1 = new Book("Atomic Habits", "James Clear", 399.0, 320);
        Book b2 = new Book("Clean Code", "Robert Martin", 650.0, 464);

        b1.displayInfo();
        System.out.println("Is expensive? " + b1.isExpensive());
        System.out.println();
        b2.displayInfo();
        System.out.println("Is expensive? " + b2.isExpensive());
        System.out.println("---");

        // ---- Exercise 3: Rectangle class ----
        Rectangle r1 = new Rectangle(5.0, 3.0);
        Rectangle r2 = new Rectangle(10.0, 2.5);
        Rectangle r3 = new Rectangle(7.5, 7.5);

        Rectangle[] rectangles = {r1, r2, r3};
        for (int i = 0; i < rectangles.length; i++) {
            Rectangle r = rectangles[i];
            System.out.println("Rectangle " + (i + 1) + " -> Area: " +
                    r.calculateArea() + ", Perimeter: " + r.calculatePerimeter());
        }
        System.out.println("---");

        // ---- Exercise 4: Array of Book objects, find highest price ----
        Book[] books = {
            new Book("Deep Work", "Cal Newport", 450.0, 296),
            new Book("The Alchemist", "Paulo Coelho", 250.0, 197),
            new Book("Sapiens", "Yuval Noah Harari", 599.0, 443),
            new Book("Ikigai", "Hector Garcia", 299.0, 208)
        };

        Book mostExpensive = books[0];
        for (Book b : books) {
            if (b.price > mostExpensive.price) {
                mostExpensive = b;
            }
        }
        System.out.println("Most expensive book:");
        mostExpensive.displayInfo();
        System.out.println("---");

        // ---- Exercise 5: static totalBooksCreated ----
        // By this point we've created b1, b2, and 4 books in the books array
        // = 6 total Book objects across the whole program
        System.out.println("Total books created so far: " + Book.totalBooksCreated);
    }
}
