package de.fh_rosenheim.algorithmen.lecture04;



public class HeapSort {

    // methods to get index of the parent or left/right child
    // of the node at index i
    private static int parent(int i) {
        // TODO
        return (i - 1) / 2;
    }
    private static int left(int i) {
        return 2 * i + 1;
    }
    private static int right(int i) {
        return 2 * i + 2;
    }

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

    // restore max-heap property for the heap with
    // parent node at index i
    // assumes children of array[i] are roots of max-heaps
    public static void maxHeapify(Comparable[] array, int i, int n) {
        int l = left(i);
        int r = right(i);
        // TODO
        int largest = i;
        if (l <= n && less(array[l], array[i])) {
            largest = l;
        }
        if (r <= n && less(array[largest], array[r])) {
            largest = r;
        }
        if (largest != i) {
            exchange(array, i, largest);
            maxHeapify(array, largest, n);
        }
    }

    // turn an arbitrary array into a max-heap
    public static void buildMaxHeap(Comparable[] array) {
        // TODO
        int heapMaxIdx = array.length - 1;
        for (int i = heapMaxIdx / 2; i >= 0; i--) {
            maxHeapify(array, i, heapMaxIdx);
        }
    }

    // heap sort
    public static void heapSort(Comparable[] array) {
        int n = array.length - 1;
        // TODO
        buildMaxHeap(array);
        for (int i = n - 1; i > 0; i--) {
            exchange(array, 0, i);  // since A[0] is max element
            maxHeapify(array, 0, i);
        }
    }


    public static void main(String[] args) {
        Integer[] a = {2, 1, 5, 6, 4, 8, 7, 3};
        QuickSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
