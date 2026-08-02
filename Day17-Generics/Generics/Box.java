public class Box<T> {
    private T content;

    void set(T content) {
        this.content = content;
    }

    T get() {
        return content;
    }

    boolean isEmpty() {
        return content == null;
    }
}
