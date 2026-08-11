public class StringBuilderDeepDiveDemo {
    public static void main(String[] args) {

        // ---- Core methods: append, insert, delete, replace, reverse ----
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" World");
        sb.append(123); // append works with any type, auto-converts to String
        System.out.println("After appends: " + sb);

        sb.insert(5, ",");
        System.out.println("After insert: " + sb);

        sb.delete(5, 6); // remove index 5 (inclusive) to 6 (exclusive)
        System.out.println("After delete: " + sb);

        sb.deleteCharAt(0);
        System.out.println("After deleteCharAt(0): " + sb);

        sb.replace(0, 4, "HELLO");
        System.out.println("After replace: " + sb);

        StringBuilder toReverse = new StringBuilder("Java");
        toReverse.reverse();
        System.out.println("Reversed 'Java': " + toReverse);
        System.out.println("---");

        // ---- Chaining: most methods return the StringBuilder itself ----
        StringBuilder chained = new StringBuilder();
        chained.append("Java").append(" is").append(" fun").reverse();
        System.out.println("Chained + reversed: " + chained);
        System.out.println("---");

        // ---- Inspection methods ----
        StringBuilder info = new StringBuilder("Programming is fun");
        System.out.println("length(): " + info.length());
        System.out.println("charAt(2): " + info.charAt(2));
        System.out.println("indexOf(\"fun\"): " + info.indexOf("fun"));
        System.out.println("substring(2, 6): " + info.substring(2, 6)); // returns a regular String
        System.out.println("---");

        // ---- Converting back to a String ----
        String result = info.toString();
        System.out.println("As a String: " + result + " (type check via .equals works: " +
                result.equals("Programming is fun") + ")");
        System.out.println("---");

        // ---- StringBuilder vs StringBuffer ----
        StringBuffer buffer = new StringBuffer(); // same API, but thread-safe (synchronized)
        buffer.append("Thread-safe version");
        System.out.println("StringBuffer result: " + buffer);
        System.out.println("---");

        // ---- Capacity: performance detail ----
        StringBuilder withCapacity = new StringBuilder(50); // pre-allocates space
        System.out.println("Initial capacity: " + withCapacity.capacity());
        withCapacity.append("Short text");
        System.out.println("Length after append: " + withCapacity.length());
        System.out.println("Capacity still: " + withCapacity.capacity()); // unchanged, still fits
    }
}
