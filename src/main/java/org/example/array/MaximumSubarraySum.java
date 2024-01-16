package org.example.array;

public class MaximumSubarraySum {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; // 6
        assert maxSubArray(arr) == 6;

        printMaxSubArray(arr);
    }


    /**
     * Kadane's algorithm:
     * The idea of Kadane’s algorithm is to maintain a variable max_ending_here
     * that stores the maximum sum contiguous subarray ending at current index
     * and a variable max_so_far stores the maximum sum of contiguous subarray found so far.
     * Everytime there is a positive-sum value in max_ending_here compare it with max_so_far
     * and update max_so_far if it is greater than max_so_far.
     * Time complexity: O(n)
     */
    private static int maxSubArray(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = Math.max(arr[0], 0);

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere += arr[i];
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
            maxEndingHere = Math.max(maxEndingHere, 0);
        }

        return maxSoFar;
    }


    private static void printMaxSubArray(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = Math.max(arr[0], 0);
        int start = 0;
        int end = 0;
        int s = 0;

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere += arr[i];
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = s;
                end = i;
            }
            maxEndingHere = Math.max(maxEndingHere, 0);
            if (maxEndingHere == 0) {
                s = i + 1;
            }
        }

        System.out.println("Maximum contiguous sum is " + maxSoFar);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);
    }
}
