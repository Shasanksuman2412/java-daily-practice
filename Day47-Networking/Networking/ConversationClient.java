import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

public class ConversationClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5004;

        try (Socket socket = new Socket(host, port)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String[] messages = {"Hello", "How are you?", "This is message three"};

            for (String msg : messages) {
                out.println(msg);              // send
                String reply = in.readLine();  // wait for the server's reply BEFORE sending the next one
                System.out.println("Server replied: " + reply);
            }

            out.println("BYE"); // tells the server to close the connection
            System.out.println("Conversation ended.");

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
