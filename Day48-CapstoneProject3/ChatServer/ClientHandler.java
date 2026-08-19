import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;

public class ClientHandler implements Runnable {

    private Socket socket;
    private List<PrintWriter> allWriters; // shared broadcast list, guarded by ChatServer
    private String username;
    private PrintWriter out;

    ClientHandler(Socket socket, List<PrintWriter> allWriters) {
        this.socket = socket;
        this.allWriters = allWriters;
    }

    @Override
    public void run() {
        try (socket) { // Socket is AutoCloseable (Day 42) - closes automatically when this method ends
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // ---- First line from the client is treated as their username ----
            username = in.readLine();
            if (username == null || username.isBlank()) {
                username = "Anonymous";
            }
            System.out.println(username + " has joined.");

            synchronized (allWriters) { // Day 21's thread-safety concept applied here
                allWriters.add(out);
            }
            broadcast("SERVER", username + " has joined the chat.");

            // ---- Main loop: read messages from this client until they disconnect ----
            String message;
            while ((message = in.readLine()) != null) {
                if (message.equalsIgnoreCase("EXIT")) {
                    break;
                }
                System.out.println(username + ": " + message);
                MessageStore.saveMessage(username, message); // Day 45's JDBC persistence
                broadcast(username, message);
            }

        } catch (IOException e) {
            System.out.println("Connection error with " + username + ": " + e.getMessage());
        } finally {
            synchronized (allWriters) {
                allWriters.remove(out);
            }
            broadcast("SERVER", username + " has left the chat.");
            System.out.println(username + " disconnected.");
        }
    }

    // ---- Sends a message to EVERY connected client ----
    private void broadcast(String from, String content) {
        String formatted = from + ": " + content;
        synchronized (allWriters) {
            for (PrintWriter writer : allWriters) {
                writer.println(formatted);
            }
        }
    }
}
