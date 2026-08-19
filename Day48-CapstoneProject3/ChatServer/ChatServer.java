import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ChatServer {
    public static void main(String[] args) {

        int port = 6000;
        MessageStore.initialize(); // sets up the SQLite table if needed

        // synchronizedList: a thread-safe List (Day 16 + Day 21 combined),
        // since multiple client threads will add/remove/read from it concurrently
        List<PrintWriter> allWriters = Collections.synchronizedList(new ArrayList<>());

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Chat server listening on port " + port + "...");
            MessageStore.printRecentHistory(10);

            while (true) {
                Socket clientSocket = serverSocket.accept(); // blocks until the next client connects
                ClientHandler handler = new ClientHandler(clientSocket, allWriters);
                new Thread(handler).start(); // each client gets its OWN thread
            }

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
