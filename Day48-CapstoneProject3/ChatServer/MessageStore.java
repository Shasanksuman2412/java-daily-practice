import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MessageStore {

    private static final String URL = "jdbc:sqlite:chat.db";

    // ---- Sets up the messages table if it doesn't already exist ----
    public static void initialize() {
        String createTable = """
                CREATE TABLE IF NOT EXISTS messages (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    username TEXT NOT NULL,
                    content TEXT NOT NULL,
                    timestamp TEXT DEFAULT CURRENT_TIMESTAMP
                )
                """;
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(createTable);
        } catch (SQLException e) {
            System.out.println("Failed to initialize message store: " + e.getMessage());
        }
    }

    // ---- Saves a single message ----
    public static void saveMessage(String username, String content) {
        String insertSql = "INSERT INTO messages (username, content) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, content);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Failed to save message: " + e.getMessage());
        }
    }

    // ---- Prints the most recent N messages - used to show history to newly joined clients ----
    public static void printRecentHistory(int limit) {
        String selectSql = "SELECT username, content, timestamp FROM messages ORDER BY id DESC LIMIT ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(selectSql)) {
            pstmt.setInt(1, limit);
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("--- Recent chat history ---");
                java.util.List<String> lines = new java.util.ArrayList<>();
                while (rs.next()) {
                    lines.add("[" + rs.getString("timestamp") + "] " +
                            rs.getString("username") + ": " + rs.getString("content"));
                }
                java.util.Collections.reverse(lines); // oldest first, since query was DESC
                lines.forEach(System.out::println);
                System.out.println("--- End of history ---");
            }
        } catch (SQLException e) {
            System.out.println("Failed to read history: " + e.getMessage());
        }
    }
}
