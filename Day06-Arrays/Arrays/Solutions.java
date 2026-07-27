public class Solutions {
    public static void main(String[] args) {

        // ---- Exercise 1: Print in reverse ----
        int[] nums1 = {10, 20, 30, 40, 50};
        System.out.println("Reversed:");
        for (int i = nums1.length - 1; i >= 0; i--) {
            System.out.println(nums1[i]);
        }
        System.out.println("---");

        // ---- Exercise 2: Count even and odd numbers ----
        int[] nums2 = {12, 7, 22, 9, 4, 15, 30};
        int evenCount = 0, oddCount = 0;
        for (int n : nums2) {
            if (n % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        System.out.println("Even count: " + evenCount);
        System.out.println("Odd count: " + oddCount);
        System.out.println("---");

        // ---- Exercise 3: Second largest DISTINCT element ----
        int[] nums3 = {45, 89, 23, 67, 89, 12};
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int n : nums3) {
            if (n > largest) {
                secondLargest = largest; // old largest demotes to second
                largest = n;
            } else if (n > secondLargest && n != largest) {
                // only update if it's not just a duplicate of the largest
                secondLargest = n;
            }
        }
        System.out.println("Largest: " + largest);
        System.out.println("Second largest (distinct): " + secondLargest);
        System.out.println("---");

        // ---- Exercise 4: Reverse an array in place ----
        int[] nums4 = {1, 2, 3, 4, 5};
        System.out.print("Before: ");
        for (int n : nums4) System.out.print(n + " ");
        System.out.println();

        int start = 0;
        int end = nums4.length - 1;
        while (start < end) {
            int temp = nums4[start];
            nums4[start] = nums4[end];
            nums4[end] = temp;
            start++;
            end--;
        }

        System.out.print("After: ");
        for (int n : nums4) System.out.print(n + " ");
        System.out.println();
        System.out.println("---");

        // ---- Exercise 5: 2D array row and column sums ----
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Row sums:");
        for (int row = 0; row < matrix.length; row++) {
            int rowSum = 0;
            for (int col = 0; col < matrix[row].length; col++) {
                rowSum += matrix[row][col];
            }
            System.out.println("Row " + row + ": " + rowSum);
        }

        System.out.println("Column sums:");
        for (int col = 0; col < matrix[0].length; col++) {
            int colSum = 0;
            for (int row = 0; row < matrix.length; row++) {
                colSum += matrix[row][col];
            }
            System.out.println("Column " + col + ": " + colSum);
        }
    }
}
