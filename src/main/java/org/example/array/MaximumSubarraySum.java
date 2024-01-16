package org.example.array;

public class MaximumSubarraySum {

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 }; // 6
        assert maxSubArray(arr) == 6;
    }


    // Kadane's algorithm: the idea is to maintain a local maximum sum at each index
    // and a global maximum sum so far. The local maximum sum at each index is the
    // maximum of the current element and the sum of the current element and the
    // local maximum sum at the previous index. The global maximum sum so far is the
    // maximum of the local maximum sum at each index and the global maximum sum so
    // far. The local maximum sum at each index is reset to 0 if it becomes
    // negative because we don't want to include negative numbers in the sum as it
    // will decrease the sum.
    // Time complexity: O(n)
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

}
