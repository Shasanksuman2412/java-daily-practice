import java.util.Arrays;
import java.util.ArrayList;

public class Solutions {
    public static void main(String[] args) {

        // ---- Exercise 1: Sort in descending order ----
        int[] nums1 = {34, 7, 23, 89, 12};
        Arrays.sort(nums1);          // ascending first
        // reverse it manually since Arrays.sort() has no built-in descending option for int[]
        for (int i = 0; i < nums1.length / 2; i++) {
            int temp = nums1[i];
            nums1[i] = nums1[nums1.length - 1 - i];
            nums1[nums1.length - 1 - i] = temp;
        }
        System.out.println("Descending: " + Arrays.toString(nums1));
        System.out.println("---");

        // ---- Exercise 2: Bubble sort with a pass counter ----
        int[] nums2 = {5, 1, 4, 2, 8};
        int swapCount = 0;
        for (int i = 0; i < nums2.length - 1; i++) {
            for (int j = 0; j < nums2.length - 1 - i; j++) {
                if (nums2[j] > nums2[j + 1]) {
                    int temp = nums2[j];
                    nums2[j] = nums2[j + 1];
                    nums2[j + 1] = temp;
                    swapCount++;
                }
            }
        }
        System.out.println("Sorted: " + Arrays.toString(nums2));
        System.out.println("Total swaps: " + swapCount);
        System.out.println("---");

        // ---- Exercise 3: Linear search returning ALL matching indexes ----
        int[] nums3 = {3, 7, 3, 9, 3, 5};
        System.out.print("Indexes where 3 appears: ");
        for (int i = 0; i < nums3.length; i++) {
            if (nums3[i] == 3) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        System.out.println("---");

        // ---- Exercise 4: Manual binary search ----
        int[] sortedArray = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72};
        int target = 23;
        int low = 0;
        int high = sortedArray.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] == target) {
                result = mid;
                break;
            } else if (sortedArray[mid] < target) {
                low = mid + 1;  // target must be in the right half
            } else {
                high = mid - 1; // target must be in the left half
            }
        }
        System.out.println("Manual binary search for " + target + " -> index: " + result);
        System.out.println("---");

        // ---- Exercise 5: ArrayList of names ----
        ArrayList<String> names = new ArrayList<>();
        names.add("Shasank");
        names.add("Raj");
        names.add("Priya");
        names.add("Amit");
        names.add("Neha");

        names.remove("Raj"); // removes BY VALUE, not by index

        System.out.println("Final list: " + names);
        System.out.println("Size: " + names.size());
        System.out.println("Contains 'Priya'? " + names.contains("Priya"));
        System.out.println("Contains 'Raj'? " + names.contains("Raj"));
    }
}
