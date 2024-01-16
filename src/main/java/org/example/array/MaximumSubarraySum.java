package org.example.array;

public class MaximumSubarraySum {

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 }; // 6
        System.out.println(maxSubArray(arr));
        assert maxSubArray(arr) == 6;
    }

    private static int maxSubArray(int[] arr) {
        // TODO: 1/16/24 write Kadane's algorithm

        int maxSoFar = arr[0];
        int maxEndingHere = Math.max(arr[0], 0);
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere += arr[i];
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
            maxEndingHere = Math.max(maxEndingHere, 0);
        }

        return maxSoFar;
    }

}
