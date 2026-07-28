import java.util.Arrays;
import java.util.ArrayList;

public class ArrayOperationsDemo {
    public static void main(String[] args) {

        // ---- Built-in sort ----
        int[] nums = {5, 2, 8, 1, 9};
        System.out.println("Before sort: " + Arrays.toString(nums));
        Arrays.sort(nums); // sorts in place, ascending
        System.out.println("After sort: " + Arrays.toString(nums));
        System.out.println("---");

        // ---- Manual sort: Bubble Sort ----
        int[] bubbleNums = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Before bubble sort: " + Arrays.toString(bubbleNums));
        for (int i = 0; i < bubbleNums.length - 1; i++) {
            for (int j = 0; j < bubbleNums.length - 1 - i; j++) {
                if (bubbleNums[j] > bubbleNums[j + 1]) {
                    int temp = bubbleNums[j];
                    bubbleNums[j] = bubbleNums[j + 1];
                    bubbleNums[j + 1] = temp;
                }
            }
        }
        System.out.println("After bubble sort: " + Arrays.toString(bubbleNums));
        System.out.println("---");

        // ---- Linear search ----
        int[] searchArray = {23, 45, 12, 67, 34, 89};
        int target = 67;
        int foundIndex = -1;
        for (int i = 0; i < searchArray.length; i++) {
            if (searchArray[i] == target) {
                foundIndex = i;
                break;
            }
        }
        System.out.println("Linear search for " + target + " -> found at index: " + foundIndex);
        System.out.println("---");

        // ---- Binary search (array must be sorted first) ----
        int[] sortedArray = {12, 23, 34, 45, 67, 89};
        int binaryResult = Arrays.binarySearch(sortedArray, 45);
        System.out.println("Binary search for 45 -> found at index: " + binaryResult);
        System.out.println("---");

        // ---- ArrayList: a resizable array ----
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("ArrayList after adds: " + list);
        list.remove(0); // removes element AT index 0 (removes the 10)
        System.out.println("ArrayList after removing index 0: " + list);
        System.out.println("Size: " + list.size());
        System.out.println("---");

        // ---- Arrays utility methods ----
        int[] fillArray = new int[5];
        Arrays.fill(fillArray, 7); // fill every element with 7
        System.out.println("Filled array: " + Arrays.toString(fillArray));

        int[] originalArray = {1, 2, 3};
        int[] copiedArray = Arrays.copyOf(originalArray, originalArray.length);
        copiedArray[0] = 99; // modifying the copy doesn't affect the original
        System.out.println("Original: " + Arrays.toString(originalArray));
        System.out.println("Copy (modified): " + Arrays.toString(copiedArray));
    }
}
