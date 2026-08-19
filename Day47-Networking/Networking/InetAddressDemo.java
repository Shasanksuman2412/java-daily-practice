import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) {

        try {
            InetAddress localhost = InetAddress.getByName("localhost");
            System.out.println("localhost resolves to: " + localhost.getHostAddress());

            InetAddress loopback = InetAddress.getLoopbackAddress();
            System.out.println("Loopback address: " + loopback.getHostAddress());

        } catch (UnknownHostException e) {
            System.out.println("Could not resolve host: " + e.getMessage());
        }

        // ---- Deliberately triggering UnknownHostException ----
        try {
            InetAddress bad = InetAddress.getByName("this-host-does-not-exist.invalid");
            System.out.println(bad.getHostAddress()); // never reached
        } catch (UnknownHostException e) {
            System.out.println("Caught expected UnknownHostException: " + e.getMessage());
        }
    }
}
