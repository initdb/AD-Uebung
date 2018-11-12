public class RadixSort {

    /**
     * sorts array of Integers using CountingSort (see Exercise Sheet #5)
     * @param input integer array given as input
     * @param k     defines maximum integer value in input; all integers must in range [0..k]
     * @return input array is sorted in a stable (!!) manner
     */
    public static Integer[] sortInteger(Integer[] input, Integer k) {

        Integer[] output = new Integer[input.length];    // array that will take sorted result.

        // count how often each value occurs
        int[] count = new int[k + 1];
        for (Integer j : input) {
            count[j]++;
        }

        // count in "count[j]" how many elements are <= j
        for (int j = 1; j <= k; j++) {
            count[j] = count[j] + count[j - 1];
        }

        // iterate over input, put each element into correct position of result array
        // using the computed cumulated frequencies in count
        for (int j = input.length - 1; j >= 0; j--) {
            int currentInt = input[j];
            // count[currentInt] elements are smaller than currentInt
            // put currentInt to index count[currentInt] - 1
            output[count[currentInt] - 1] = input[j];
            count[currentInt]--;
        }

        return output;
    }

    /**
     * directly sorts the array of w-character strings in ascending order.
     * Assumption: each char is an 8-bit value (extended ASCII)
     *
     * @param a the array to be sorted
     * @param w the number of characters per string
     */
    public static String[] sortStrings(String[] a, int w)
    {
        // loop for length of each String, with index i
        for(int i = w-1; 0 <= i; i--)
        {
            int[] count = new int[256];
            String[] output = new String[a.length];
            // count current column, with index j
            for(int j = 0; j < a.length; j++)
            {
                count[a[j].charAt(i)]++;
            }

            // sum up indexes; checks out
            for (int j = 1; j < count.length; j++) {
                count[j] = count[j] + count[j - 1];
            }

            // iterate over input, put each element into correct position of result array
            // using the computed cumulated frequencies in count
            for (int j = a.length-1; j >= 0; j--) {
                int currentChar = (int) a[j].charAt(i);
                // count[currentInt] elements are smaller than currentInt
                // put currentInt to index count[currentInt] - 1
                output[count[currentChar] - 1] = a[j];
                count[currentChar]--;
            }
            a = output;
        }

        return a;
    }
}
