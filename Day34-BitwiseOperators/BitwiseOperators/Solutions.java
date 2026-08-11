public class Solutions {

    // ---- Exercise 1: Check if a number is a power of 2 ----
    static boolean isPowerOfTwo(int n) {
        // n-1 flips all bits after the lowest set bit (including that bit itself).
        // ANDing n with (n-1) clears that lowest set bit.
        // If n was a power of 2 (only ONE bit set), clearing it leaves 0.
        return n > 0 && (n & (n - 1)) == 0;
    }

    // ---- Exercise 2: Count the number of set bits ----
    static int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1); // adds 1 if the lowest bit is set, 0 otherwise
            n >>= 1;          // shift right, eventually reaching 0
        }
        return count;
    }

    // ---- Exercise 4: Toggle a bit flag ----
    static int toggleFlag(int permissions, int flag) {
        return permissions ^ flag; // XOR with the flag flips just that bit
    }

    // ---- Exercise 5: Convert a positive int to binary manually ----
    static String toBinary(int n) {
        if (n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n & 1); // lowest bit, 0 or 1
            n >>= 1;
        }
        return sb.reverse().toString(); // we built it backwards, so reverse at the end
    }

    public static void main(String[] args) {

        // ---- Exercise 1 ----
        System.out.println("isPowerOfTwo(16) = " + isPowerOfTwo(16)); // true
        System.out.println("isPowerOfTwo(18) = " + isPowerOfTwo(18)); // false
        System.out.println("isPowerOfTwo(1) = " + isPowerOfTwo(1));   // true
        System.out.println("---");

        // ---- Exercise 2 ----
        System.out.println("countSetBits(7) = " + countSetBits(7));   // 3 (111)
        System.out.println("Built-in check: " + Integer.bitCount(7));
        System.out.println("---");

        // ---- Exercise 3: Swap array elements using XOR ----
        int[] arr = {10, 20, 30, 40};
        System.out.print("Before swap: ");
        for (int n : arr) System.out.print(n + " ");
        System.out.println();

        int i = 0, j = 3;
        if (i != j) { // guard against swapping an element with itself - XOR trick breaks otherwise
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }

        System.out.print("After swap: ");
        for (int n : arr) System.out.print(n + " ");
        System.out.println();
        System.out.println("---");

        // ---- Exercise 4 ----
        final int WRITE = 2;
        int permissions = 1 | WRITE; // READ + WRITE
        System.out.println("Original permissions: " + permissions);
        permissions = toggleFlag(permissions, WRITE);
        System.out.println("After toggling WRITE off: " + permissions);
        permissions = toggleFlag(permissions, WRITE);
        System.out.println("After toggling WRITE on again: " + permissions); // back to original
        System.out.println("---");

        // ---- Exercise 5 ----
        int[] testNumbers = {5, 10, 255, 1};
        for (int num : testNumbers) {
            System.out.println("toBinary(" + num + ") = " + toBinary(num) +
                    " (built-in: " + Integer.toBinaryString(num) + ")");
        }
    }
}
