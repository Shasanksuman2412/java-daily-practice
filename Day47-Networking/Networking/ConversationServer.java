import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

public class ConversationServer {
    public static void main(String[] args) {
        int port = 5004;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Conversation server listening on port " + port + "...");

            try (Socket clientSocket = serverSocket.accept()) {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                while (true) {
                    String message = in.readLine(); // blocks until client sends something
                    if (message == null || message.equals("BYE")) {
                        System.out.println("Client ended the conversation.");
                        break;
                    }
                    System.out.println("Client said: " + message);
                    out.println("Server received: " + message);
                }
            }

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
