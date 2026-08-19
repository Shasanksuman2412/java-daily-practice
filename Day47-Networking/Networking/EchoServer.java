import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

public class EchoServer {
    public static void main(String[] args) {
        int port = 5002;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Echo server listening on port " + port + "...");

            try (Socket clientSocket = serverSocket.accept()) {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String message = in.readLine();
                System.out.println("Echoing back: " + message);
                out.println(message); // send back EXACTLY what was received
            }

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
