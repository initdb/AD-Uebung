package de.fh_rosenheim.algorithmen.lecture05;

public class BinarySearch {

    // wrapper (needed for recursive variant)
    public static int binarySearchRec(Comparable a[], Comparable key) {
        return binarySearchRec(a, 0, a.length - 1, key);
    }

    // binary search (recursive variant)
    public static int binarySearchRec(Comparable a[], int l, int r, Comparable key) {
        if (l > r)            // not found
            return l - 1;
        // todo
        int m = (l + r) / 2;
        if (key.compareTo(a[m]) > 0)       // Key in left half
            return binarySearchRec(a, l, m - 1, key);
        else if (key.compareTo(a[m]) < 0)  // Key in right half
            return binarySearchRec(a, m + 1, r, key);
        else                  // a[m] == key
            return m;
    }


    // binary search (iterative variant)
    public static int binarySearchIter(Comparable a[], Comparable key) {
        int l = 0;
        int r = a.length - 1;
        // todo
        while (l <= r) {
            int m = (l + r) / 2;
            if (key.compareTo(a[m]) > 0) {                  // key in right half
                r = m - 1;
            } else if (key.compareTo(a[m]) < 0) {          // key in left half
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

}




















