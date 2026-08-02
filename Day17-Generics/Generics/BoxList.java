import java.util.ArrayList;
import java.util.List;

public class BoxList<T> {
    private List<T> items = new ArrayList<>();

    void add(T item) {
        items.add(item);
    }

    T getFirst() {
        return items.get(0);
    }

    int count() {
        return items.size();
    }
}
