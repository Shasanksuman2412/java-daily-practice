import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {

        String host = "localhost";
        int port = 6000;

        try (Socket socket = new Socket(host, port)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter your username: ");
            String username = scanner.nextLine();
            out.println(username); // first line sent is treated as the username by ClientHandler

            // ---- Background thread: continuously prints incoming messages ----
            // Needed because reading (in.readLine()) and writing (Scanner input)
            // both BLOCK - without a separate thread, we couldn't do both at once.
            Thread listenerThread = new Thread(() -> {
                try {
                    String line;
                    while ((line = in.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    System.out.println("Disconnected from server.");
                }
            });
            listenerThread.setDaemon(true); // won't prevent the program from exiting
            listenerThread.start();

            System.out.println("Connected! Type messages and press Enter. Type EXIT to leave.");

            // ---- Main thread: reads user input and sends it ----
            while (true) {
                String message = scanner.nextLine();
                out.println(message);
                if (message.equalsIgnoreCase("EXIT")) {
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage() + " (is ChatServer running?)");
        }
    }
}
