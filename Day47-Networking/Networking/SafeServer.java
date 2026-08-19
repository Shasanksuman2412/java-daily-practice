import java.net.ServerSocket;
import java.net.BindException;
import java.io.IOException;

public class SafeServer {
    public static void main(String[] args) {
        int port = 5000; // same port as SimpleServer - try running this WHILE SimpleServer is active

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started successfully on port " + port);
            serverSocket.accept(); // would block waiting for a client

        } catch (BindException e) {
            System.out.println("Port " + port + " is already in use - " +
                    "is another server instance already running?");
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
