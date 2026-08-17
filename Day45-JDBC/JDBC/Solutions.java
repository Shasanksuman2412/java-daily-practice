import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Solutions {

    // ---- Exercise 2: query with a WHERE clause ----
    static void findBooksByAuthor(Connection conn, String author) throws SQLException {
        String sql = "SELECT * FROM books WHERE author = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, author);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + ": " + rs.getString("title") +
                            " (" + rs.getInt("year") + ")");
                }
            }
        }
    }

    // ---- Exercise 3: aggregate query, index-based column access ----
    static int countBooks(Connection conn) throws SQLException {
        String sql = "SELECT COUNT(*) FROM books";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            rs.next(); // one row guaranteed for COUNT(*)
            return rs.getInt(1); // index 1 = first (and only) column
        }
    }

    // ---- Exercise 4: transaction-style inserts with rollback ----
    static void insertBooksTransactionally(Connection conn, boolean forceFailure) throws SQLException {
        conn.setAutoCommit(false); // start a transaction - nothing saves until commit()
        try {
            insertBook(conn, "Book One", "Author A", 2020);
            insertBook(conn, "Book Two", "Author B", 2021);

            if (forceFailure) {
                throw new SQLException("Simulated failure mid-transaction");
            }

            insertBook(conn, "Book Three", "Author C", 2022);
            conn.commit(); // all-or-nothing: only saves if EVERY insert succeeded
            System.out.println("Transaction committed - all 3 books saved.");
        } catch (SQLException e) {
            conn.rollback(); // undo everything since setAutoCommit(false)
            System.out.println("Transaction rolled back: " + e.getMessage());
        } finally {
            conn.setAutoCommit(true); // restore normal behavior for future statements
        }
    }

    static void insertBook(Connection conn, String title, String author, int year) throws SQLException {
        String sql = "INSERT INTO books (title, author, year) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setInt(3, year);
            pstmt.executeUpdate();
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:sqlite:books.db";

        try (Connection conn = DriverManager.getConnection(url)) {

            // ---- Exercise 1: create table, insert records ----
            String createTable = """
                    CREATE TABLE IF NOT EXISTS books (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        title TEXT NOT NULL,
                        author TEXT NOT NULL,
                        year INTEGER
                    )
                    """;
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(createTable);
                stmt.execute("DELETE FROM books"); // clean slate for repeatable demo runs
            }

            insertBook(conn, "The Hobbit", "J.R.R. Tolkien", 1937);
            insertBook(conn, "1984", "George Orwell", 1949);
            insertBook(conn, "Dune", "Frank Herbert", 1965);
            insertBook(conn, "Animal Farm", "George Orwell", 1945);

            System.out.println("All books:");
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM books")) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + ": " + rs.getString("title") +
                            " by " + rs.getString("author") + " (" + rs.getInt("year") + ")");
                }
            }
            System.out.println("---");

            // ---- Exercise 2 ----
            System.out.println("Books by George Orwell:");
            findBooksByAuthor(conn, "George Orwell");
            System.out.println("---");

            // ---- Exercise 3 ----
            System.out.println("Total book count: " + countBooks(conn));
            System.out.println("---");

            // ---- Exercise 4: transaction demo, one success and one forced rollback ----
            insertBooksTransactionally(conn, false); // succeeds, commits
            System.out.println("Count after successful transaction: " + countBooks(conn));

            insertBooksTransactionally(conn, true); // forced failure, rolls back
            System.out.println("Count after rolled-back transaction (unchanged): " + countBooks(conn));
            System.out.println("---");

            // ---- Exercise 5: simple search CLI (uncomment to try interactively) ----
            // Scanner scanner = new Scanner(System.in);
            // while (true) {
            //     System.out.print("Enter an author to search (or 'exit'): ");
            //     String input = scanner.nextLine();
            //     if (input.equalsIgnoreCase("exit")) break;
            //     findBooksByAuthor(conn, input);
            // }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
