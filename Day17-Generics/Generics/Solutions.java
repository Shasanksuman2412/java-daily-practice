public class Solutions {

    // ---- Exercise 2: Generic method to find the max of an array ----
    public static <T extends Comparable<T>> T findMax(T[] array) {
        T max = array[0];
        for (T item : array) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    // ---- Exercise 3: Generic Pair swap method ----
    public static <K, V> Pair<V, K> swap(Pair<K, V> pair) {
        return new Pair<>(pair.getValue(), pair.getKey());
    }

    public static void main(String[] args) {

        // ---- Exercise 1: Generic Stack ----
        Stack<Integer> intStack = new Stack<>();
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        System.out.println("Popped from intStack: " + intStack.pop()); // 30
        System.out.println("Popped from intStack: " + intStack.pop()); // 20

        Stack<String> stringStack = new Stack<>();
        stringStack.push("a");
        stringStack.push("b");
        System.out.println("Popped from stringStack: " + stringStack.pop()); // b
        System.out.println("---");

        // ---- Exercise 2: findMax ----
        Integer[] intArray = {45, 12, 89, 23};
        Double[] doubleArray = {3.5, 9.1, 2.4};
        String[] stringArray = {"banana", "apple", "cherry"};

        System.out.println("Max int: " + findMax(intArray));
        System.out.println("Max double: " + findMax(doubleArray));
        System.out.println("Max string (alphabetically): " + findMax(stringArray));
        System.out.println("---");

        // ---- Exercise 3: Pair swap ----
        Pair<String, Integer> original = new Pair<>("age", 21);
        Pair<Integer, String> swapped = swap(original);
        System.out.println("Original: " + original);
        System.out.println("Swapped: " + swapped);
        System.out.println("---");

        // ---- Exercise 4: NumberBox ----
        NumberBox<Integer> intBox = new NumberBox<>(10);
        NumberBox<Double> doubleBox = new NumberBox<>(3.5);
        System.out.println("intBox doubled: " + intBox.doubled());
        System.out.println("doubleBox doubled: " + doubleBox.doubled());
        System.out.println("---");

        // ---- Exercise 5: BoxList holding multiple items ----
        BoxList<String> nameBox = new BoxList<>();
        nameBox.add("Shasank");
        nameBox.add("Priya");
        nameBox.add("Amit");
        System.out.println("First name in box: " + nameBox.getFirst());
        System.out.println("Total names in box: " + nameBox.count());
    }
}
