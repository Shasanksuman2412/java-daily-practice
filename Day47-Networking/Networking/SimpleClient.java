import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

public class SimpleClient {
    public static void main(String[] args) {

        String host = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(host, port)) { // connect to the server
            System.out.println("Connected to server at " + host + ":" + port);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("Hello, server!");
            System.out.println("Message sent.");

            String response = in.readLine();
            System.out.println("Server replied: " + response);

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage() +
                    " (is SimpleServer running first?)");
        }
    }
}
