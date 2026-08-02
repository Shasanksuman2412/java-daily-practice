import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    private List<T> items = new ArrayList<>();

    void push(T item) {
        items.add(item);
    }

    T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot pop from an empty stack");
        }
        return items.remove(items.size() - 1); // removes and returns the LAST item
    }

    boolean isEmpty() {
        return items.isEmpty();
    }
}
