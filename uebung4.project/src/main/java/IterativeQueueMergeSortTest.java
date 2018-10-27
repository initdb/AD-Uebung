import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class IterativeQueueMergeSortTest {

    @org.junit.Test
    public void sortDescendingOrder() {
        System.out.println("Testing array that is sorted in descending order ...");

        Integer[] nums = new Integer[30];
        for (int i = 0; i < nums.length; i++)
            nums[i] = nums.length - i;
        System.out.println("Input : " + Arrays.toString(nums));

        IterativeQueueMergeSort.sort(nums);
        System.out.println("Output: " + Arrays.toString(nums));
        assertTrue("Array in descending order was correctly sorted", isSorted(nums));
    }


    @org.junit.Test
    public void sortRandomArray() {
        System.out.println("Testing random array ...");

        // Test random array
        Random r = new Random();
        Integer[] nums = new Integer[30];
        for (int i = 0; i < nums.length; i++) {
            int j = r.nextInt(nums.length);
            nums[i] = j;
        }
        System.out.println("Input : " + Arrays.toString(nums));

        IterativeQueueMergeSort.sort(nums);
        System.out.println("Output: " + Arrays.toString(nums));
        assertTrue("Random array was correctly sorted", isSorted(nums));



    }

    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i].compareTo(a[i - 1]) < 0) return false;
        return true;
    }
}