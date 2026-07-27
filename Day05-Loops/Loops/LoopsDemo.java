public class LoopsDemo {
    public static void main(String[] args) {

        // ---- for loop ----
        System.out.println("for loop:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count: " + i);
        }
        System.out.println("---");

        // ---- while loop ----
        System.out.println("while loop:");
        int count = 1;
        while (count <= 5) {
            System.out.println("Count: " + count);
            count++; // don't forget this, or it loops forever!
        }
        System.out.println("---");

        // ---- do-while loop ----
        System.out.println("do-while loop (condition false from the start):");
        int num = 10;
        do {
            System.out.println("Runs at least once, num = " + num);
            num++;
        } while (num < 5); // false immediately, but body already executed once
        System.out.println("---");

        // ---- break and continue ----
        System.out.println("break and continue demo:");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) {
                break; // stop the loop entirely once i reaches 6
            }
            if (i % 2 == 0) {
                continue; // skip printing even numbers, jump to next iteration
            }
            System.out.println("Odd number: " + i);
        }
        System.out.println("---");

        // ---- Nested loops: multiplication grid ----
        System.out.println("Nested loop - 3x3 multiplication grid:");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print((i * j) + "\t");
            }
            System.out.println(); // move to next line after each row
        }
    }
}
