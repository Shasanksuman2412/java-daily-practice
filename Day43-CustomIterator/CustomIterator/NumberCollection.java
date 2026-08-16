import java.util.Iterator;
import java.util.NoSuchElementException;

public class NumberCollection implements Iterable<Integer> {
    private int[] numbers;

    NumberCollection(int[] numbers) {
        this.numbers = numbers;
    }

    // ---- Standard iteration: every number, used by for-each ----
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < numbers.length;
            }

            @Override
            public Integer next() {
                if (!hasNext()) throw new NoSuchElementException();
                return numbers[index++];
            }
        };
    }

    // ---- Custom iteration: even numbers only ----
    public Iterator<Integer> evenOnlyIterator() {
        return new Iterator<Integer>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                while (index < numbers.length && numbers[index] % 2 != 0) {
                    index++; // skip odd numbers
                }
                return index < numbers.length;
            }

            @Override
            public Integer next() {
                if (!hasNext()) throw new NoSuchElementException();
                return numbers[index++];
            }
        };
    }
}
