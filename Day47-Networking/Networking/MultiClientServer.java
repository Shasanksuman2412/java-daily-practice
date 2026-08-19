import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

public class MultiClientServer {
    public static void main(String[] args) {

        int port = 5001;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Multi-client server listening on port " + port + "...");
            System.out.println("(Run SimpleClient multiple times, in separate terminals, pointed at port 5001)");

            while (true) {
                Socket clientSocket = serverSocket.accept(); // blocks until the NEXT client connects
                System.out.println("New client connected: " + clientSocket.getInetAddress());

                // handle each client on its own thread (Day 21), so the server
                // can keep accepting new connections while this one is being served
                new Thread(() -> handleClient(clientSocket)).start();
            }

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }

    static void handleClient(Socket clientSocket) {
        try (clientSocket) { // Socket is AutoCloseable (Day 42) - closes when this block ends
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String message = in.readLine();
            System.out.println("[" + Thread.currentThread().getName() + "] Received: " + message);

            out.println("Server (thread " + Thread.currentThread().getName() + ") says hi back!");

        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        }
    }
}
