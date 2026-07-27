public class ArraysDemo {
    public static void main(String[] args) {

        // ---- Creating and filling an array manually ----
        int[] numbers = new int[5]; // all elements default to 0
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;
        System.out.println("First element: " + numbers[0]);
        System.out.println("---");

        // ---- Array initialization shortcut ----
        int[] marks = {85, 90, 78, 92, 88};
        System.out.println("Marks[0]: " + marks[0]);
        marks[2] = 100; // modify third element (index 2)
        System.out.println("Marks after update: marks[2] = " + marks[2]);
        System.out.println("---");

        // ---- Looping with a regular for loop ----
        System.out.println("All marks (indexed for loop):");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Index " + i + ": " + marks[i]);
        }
        System.out.println("---");

        // ---- Looping with enhanced for-each loop ----
        System.out.println("All marks (for-each loop):");
        for (int mark : marks) {
            System.out.println(mark);
        }
        System.out.println("---");

        // ---- Sum and average ----
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        double average = (double) sum / marks.length;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("---");

        // ---- Finding max and min ----
        int max = marks[0];
        int min = marks[0];
        for (int mark : marks) {
            if (mark > max) max = mark;
            if (mark < min) min = mark;
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("---");

        // ---- 2D array (grid) ----
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6}
        };
        System.out.println("Element at row 1, col 2: " + grid[1][2]); // 6

        System.out.println("Full grid:");
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }
}
