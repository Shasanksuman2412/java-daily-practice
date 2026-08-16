import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer> {
    private int start;
    private int end;
    private int step;

    Range(int start, int end) {
        this(start, end, 1); // default step of 1
    }

    Range(int start, int end, int step) {
        this.start = start;
        this.end = end;
        this.step = step;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int current = start; // each call to iterator() gets its OWN fresh current

            @Override
            public boolean hasNext() {
                return current <= end;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Range exhausted");
                }
                int value = current;
                current += step;
                return value;
            }
        };
    }
}
