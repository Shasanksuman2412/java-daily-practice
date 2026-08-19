import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

public class CommandServer {
    public static void main(String[] args) {
        int port = 5003;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Command server listening on port " + port + "...");

            try (Socket clientSocket = serverSocket.accept()) {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String message = in.readLine();
                System.out.println("Received: " + message);

                if ("PING".equals(message)) {
                    out.println("PONG");
                } else {
                    out.println("Unknown command: " + message);
                }
            }

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
