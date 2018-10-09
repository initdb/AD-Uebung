package de.fh_rosenheim.algorithmen.lecture02;

public class MaximumSubarrayRecursive {

    // identifies a subarray
    public static class Subarray{
        int low;
        int high;
        int sum;
        Subarray(int l, int h, int s) {
            low = l;
            high = h;
            sum = s;
        }
    }

    public static void main(String[] args) {
        //int[] input = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        int[] input = { 13, -3, -25, 20, -3, -16};
        Subarray sol = findMaximumSubarray(input, 0, input.length - 1);
        System.out.println("Max Subarray: low=" + sol.low + ", right=" + sol.high + ", sum= " + sol.sum);
    }



    public static Subarray findMaximumSubarray(int[] array, int low, int high) {
        if (high == low) {
            return new Subarray(low, high, array[low]);
        }

        else {
            int mid = (low + high) / 2;
            Subarray leftSolution = findMaximumSubarray(array, low, mid);
            Subarray rightSolution = findMaximumSubarray(array, mid+1, high);
            Subarray midSolution = findMaxCrossingSubarray(array, low, mid, high);

            // TODO
            if (leftSolution.sum >= rightSolution.sum && leftSolution.sum >= midSolution.sum) {
                // left solution is best
                return new Subarray(leftSolution.low, leftSolution.high, leftSolution.sum);
            }

            else if (rightSolution.sum >= leftSolution.sum && rightSolution.sum >= midSolution.sum ) {
                return new Subarray(rightSolution.low, rightSolution.high, rightSolution.sum);
            }
            else {
                return new Subarray(midSolution.low, midSolution.high, midSolution.sum);
            }
        }
    }

    // computes solution that cross the middle: "Teil C"
    private static Subarray findMaxCrossingSubarray(int[] array, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = mid;

        // TODO: selber programmieren
        for (int i=mid; i>=low; i--) {
            sum += array[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }







        // TODO: selber programmieren
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int maxRight = mid;
        for (int j = mid+1; j<=high; j++) {
            sum += array[j];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = j;
            }
        }
        return new Subarray(maxLeft, maxRight, leftSum + rightSum);
    }
}