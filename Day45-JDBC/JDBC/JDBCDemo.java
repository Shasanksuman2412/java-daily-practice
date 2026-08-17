import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) {

        String url = "jdbc:sqlite:students.db"; // file-based - creates students.db in this folder

        // ---- Connecting: Connection is AutoCloseable (Day 42) ----
        try (Connection conn = DriverManager.getConnection(url)) {
            System.out.println("Connected to database successfully.");

            // ---- Creating a table using a text block (Day 39) ----
            String createTable = """
                    CREATE TABLE IF NOT EXISTS students (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        name TEXT NOT NULL,
                        marks REAL
                    )
                    """;
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(createTable);
                System.out.println("Table ready.");
            }
            System.out.println("---");

            // ---- Clearing old data so this demo is repeatable ----
            try (Statement stmt = conn.createStatement()) {
                stmt.execute("DELETE FROM students");
            }

            // ---- Inserting data with PreparedStatement (never string concatenation!) ----
            String insertSql = "INSERT INTO students (name, marks) VALUES (?, ?)";
            insertStudent(conn, insertSql, "Shasank", 85.5);
            insertStudent(conn, insertSql, "Priya", 92.0);
            insertStudent(conn, insertSql, "Amit", 78.0);
            System.out.println("---");

            // ---- Reading data with a ResultSet ----
            System.out.println("All students:");
            String selectSql = "SELECT * FROM students";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(selectSql)) {

                while (rs.next()) { // advances to next row, false when done
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    double marks = rs.getDouble("marks");
                    System.out.println(id + ": " + name + " - " + marks);
                }
            }
            System.out.println("---");

            // ---- Updating data ----
            String updateSql = "UPDATE students SET marks = ? WHERE name = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(updateSql)) {
                pstmt.setDouble(1, 90.0);
                pstmt.setString(2, "Shasank");
                int rowsAffected = pstmt.executeUpdate();
                System.out.println(rowsAffected + " row(s) updated for Shasank.");
            }
            System.out.println("---");

            // ---- Deleting data ----
            String deleteSql = "DELETE FROM students WHERE name = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(deleteSql)) {
                pstmt.setString(1, "Amit");
                int rowsDeleted = pstmt.executeUpdate();
                System.out.println(rowsDeleted + " row(s) deleted for Amit.");
            }
            System.out.println("---");

            // ---- Final state after update and delete ----
            System.out.println("Final student list:");
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(selectSql)) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + ": " + rs.getString("name") +
                            " - " + rs.getDouble("marks"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    // ---- Helper method: PreparedStatement with placeholders ----
    static void insertStudent(Connection conn, String sql, String name, double marks) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, marks);
            pstmt.executeUpdate();
            System.out.println("Inserted: " + name);
        }
    }
}
