/**
 * Created by muwo522 on 14.10.2016.
 */
public class Aktienkurse {

    // absolute Kurs
    public static final int[] changes = {1, -5, 4, 2, -7, 3, 6, -1, 2, -4, 7, -10, 2, 6, 1, -3};


    public static void main(String[] args) {

        Integer maxSum = Integer.MIN_VALUE; // keeps sum of maximum subarray (that is already known at current position)
        int low = 0;                        // - left index
        int high = 0;                       // - right index


        Integer curSum = Integer.MIN_VALUE; // keeps maximum sum of all subarrays that end at current position
        int curLow = 0;                     // - left index

        for (int pos = 0; pos < changes.length; pos++) {   // scanline: read from left to right

		// TODO

        }


        // Ausgabe
        System.out.println("Ideales Szenario:");
        System.out.println("- Einkaufstag:\t" + (low + 1));
        System.out.println("- Verkaufstag:\t" + (high + 1));
        int sum = 0;
        for (int i=low; i<=high; i++) {
            sum += changes[i];
        }
        System.out.println("- Verdienst:\t" + sum);

    }

}
