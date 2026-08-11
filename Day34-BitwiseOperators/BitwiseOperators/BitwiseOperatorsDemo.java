public class BitwiseOperatorsDemo {
    public static void main(String[] args) {

        // ---- Core bitwise operators ----
        int a = 12; // binary: 1100
        int b = 10; // binary: 1010

        System.out.println("a & b = " + (a & b));   // AND: 1000 = 8
        System.out.println("a | b = " + (a | b));   // OR:  1110 = 14
        System.out.println("a ^ b = " + (a ^ b));   // XOR: 0110 = 6
        System.out.println("~a = " + (~a));         // NOT: flips every bit -> -13
        System.out.println("---");

        // ---- Shift operators ----
        int x = 5; // binary: 0101
        System.out.println("x << 1 (left shift) = " + (x << 1));  // 10 - doubled
        System.out.println("x << 2 (left shift) = " + (x << 2));  // 20 - x4
        System.out.println("x >> 1 (right shift) = " + (x >> 1)); // 2 - halved, rounded down
        System.out.println("---");

        // ---- Unsigned right shift >>> ----
        int negative = -8;
        System.out.println("negative >> 2 (signed) = " + (negative >> 2));   // preserves sign bit
        System.out.println("negative >>> 2 (unsigned) = " + (negative >>> 2)); // very different!
        System.out.println("---");

        // ---- Practical use: checking even/odd with bitwise AND ----
        for (int n = 1; n <= 5; n++) {
            if ((n & 1) == 0) {
                System.out.println(n + " is even (bitwise check)");
            } else {
                System.out.println(n + " is odd (bitwise check)");
            }
        }
        System.out.println("---");

        // ---- Practical use: XOR swap without a temp variable ----
        int p = 5, q = 10;
        System.out.println("Before swap: p=" + p + ", q=" + q);
        p = p ^ q;
        q = p ^ q;
        p = p ^ q;
        System.out.println("After XOR swap: p=" + p + ", q=" + q);
        System.out.println("---");

        // ---- Practical use: bit flags ----
        final int READ = 1;    // 001
        final int WRITE = 2;   // 010
        final int EXECUTE = 4; // 100

        int permissions = READ | WRITE; // combine flags with OR
        System.out.println("Combined permissions value: " + permissions);

        boolean canRead = (permissions & READ) != 0;
        boolean canWrite = (permissions & WRITE) != 0;
        boolean canExecute = (permissions & EXECUTE) != 0;

        System.out.println("Can read? " + canRead);
        System.out.println("Can write? " + canWrite);
        System.out.println("Can execute? " + canExecute);

        // adding a flag later
        permissions = permissions | EXECUTE;
        System.out.println("After adding EXECUTE: can execute? " + ((permissions & EXECUTE) != 0));

        // removing a flag
        permissions = permissions & ~WRITE; // AND with the inverted flag clears just that bit
        System.out.println("After removing WRITE: can write? " + ((permissions & WRITE) != 0));
    }
}
