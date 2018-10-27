package de.fh_rosenheim.algorithmen.lecture04;

public class MergeSortIterative {

    // This class should not be instantiated.
    private MergeSortIterative() { }

    /*
    * Merge two sorted sublists into a single list
     * @param array a list containing two sorted sublists
     * @param left start index of first list
     * @param middle end index of first list
     * @param right end index of second list
     */
    private static void merge(Comparable[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        Comparable[] leftArray = new Comparable[n1 + 1];   // generate auxiliary arrays
        Comparable[] rightArray = new Comparable[n2 + 1];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[middle + 1 + j];
        }

        // sentinel values
        leftArray[n1] = Integer.MAX_VALUE;
        rightArray[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        // sentinel values allowing to skip if one of the two arrays is empty
        for (int k = left; k <= right; k++) {
            if (less(leftArray[i], rightArray[j])) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
        }
    }



    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        int n = a.length;
        // TODO





















        for (int len = 1; len < n; len *= 2) {
            for (int left = 0; left < n - len; left += len + len) {
                int middle  = left + len-1;
                int right = Math.min(left + len + len - 1, n - 1);
                merge(a, left, middle, right);
            }
        }
    }

    /***********************************************************************
     *  Helper sorting functions.
     ***************************************************************************/

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // Test function
    public static void main(String[] args) {
        Integer[] a = {5, 2, 4, 7, 1, 3, 2, 6};
        MergeSortRecursive.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }


}
