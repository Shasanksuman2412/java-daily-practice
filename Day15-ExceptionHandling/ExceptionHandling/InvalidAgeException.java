public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message); // passes the message up to Exception's constructor
    }
}
