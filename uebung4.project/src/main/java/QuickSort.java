package de.fh_rosenheim.algorithmen.lecture04;

/**
 * based on Sedgewick et al, adjusted by W. Mühlbauer
 */
public class QuickSort {

    // This class should not be instantiated.
    private QuickSort() {
    }

    /**
     * Sorting using Quicksort / Wrapper method
     *
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    // quicksort the subarray from a[l] to a[r]
    private static void sort(Comparable[] a, int l, int r) {
        // TODO
        if (l < r) {
            int p = partition(a, l, r);
            sort(a, l, p - 1);
            sort(a, p + 1, r);
        }
    }

    // Hoare partitioning
    // partition the subarray a[l..r] so that a[l..p-1] <= a[p] <= a[p+1..r]
    // and return the index p of the pivot.
    private static int partition(Comparable[] a, int l, int r) {
        // TODO
        Comparable pivot = a[r];     // assume rightmost element is pivot.
        int i = l;
        int j = r - 1;
        Comparable v = a[l];

        do {
            // find item on right side to swap
            while (a[j].compareTo(pivot) > 0 && j > l) {
                j--;
            }
            // find item on left side to swap
            while (a[i].compareTo(pivot) < 0 && i < r) {
                i++;
            }
            if (i < j) {
                exchange(a, i, j);
            }
        } while (i < j);

        // Pivot must be put to correct position
        if (a[i].compareTo(pivot) > 0) {
            exchange(a, i, r);
        }
        return i;
    }




    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        if (v == w) return false;
        return v.compareTo(w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exchange(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }




    public static void main(String[] args) {
        Integer[] a = {8, 1, 6, 4, 0, 3, 9, 5};
        QuickSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }

}
