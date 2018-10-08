//package de.fh_rosenheim.algorithmen;

/**
 * Created by Wolfgang Mühlbauer on 23.09.2018.
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] array = { 4, 1, 8, -3, 5, 7 };
        insertionSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }

    }

    public static void insertionSort(int[] array) {

        for (int j = 1; j < array.length; j++) {
            // nun Element array[j] einsortieren
            int key = array[j];
            int i = j - 1;                         // setze i zunächst auf rechten Rand des bereits sortierten Bereichs
            while (i >= 0 && array[i] > key) {     // laufe von rechts nach links
                array[i+1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }
}


