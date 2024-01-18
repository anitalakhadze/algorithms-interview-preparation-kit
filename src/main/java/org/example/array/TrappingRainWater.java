package org.example.array;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] arr = {3, 0, 0, 2, 0, 4};
        assert trapWithPrecalculation(arr) == 10;
    }

    /**
     * Approach 1: Precalculation. Time complexity: O(n).
     * Java program to find maximum amount of water that can
     * be trapped within given set of bars.
     * For every element we can precalculate and store the highest bar on the left
     * and on the right (say stored in arrays left[] and right[]).
     * Then iterate the array and use the precalculated values to find the amount of water stored in this index,
     * which is the same as (min(left[i], right[i]) – arr[i])
     */
    private static int trapWithPrecalculation(int[] arr) {
        // left[i] contains height of tallest bar to the
        // left of i'th bar including itself
        int[] left = new int[arr.length];

        // Right [i] contains height of tallest bar to
        // the right of ith bar including itself
        int[] right = new int[arr.length];

        int trappedWater = 0;

        // Fill left array
        left[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }

        // Fill right array
        right[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }

        // Calculate the accumulated water element by element
        // consider the amount of water on i'th bar, the
        // amount of water accumulated on this particular
        // bar will be equal to min(left[i], right[i]) - arr[i].
        for (int i = 0; i < arr.length; i++) {
            trappedWater += Math.min(left[i], right[i]) - arr[i];
        }

        return trappedWater;
    }

}
