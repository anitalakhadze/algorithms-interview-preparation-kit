package org.example.array;

public class FindMissingNumber {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6}; // 3
        assert findMissingNumberWithHashing(arr) == 3;
        assert findMissingNumberWithNaturalSum(arr) == 3;
    }

    /**
     * Approach 1: Hashing
     * The numbers will be in the range (1, N), an array of size N can be maintained
     * to keep record of the elements present in the given array
     */
    private static int findMissingNumberWithHashing(int[] arr) {
        int[] temp = new int[arr.length + 1]; // because the array is missing one element
        for (int i = 0; i <= temp.length; i++) {
            temp[i] = 0;
        }

        for (int j : arr) {
            temp[j - 1] = 1;
        }

        for (int i = 0; i <= temp.length; i++) {
            if (temp[i] == 0) {
                return i + 1;
            }
        }

        return -1;
    }

    /**
     * Approach 2: Natural Sum
     * The sum of first N natural numbers is N*(N+1)/2
     * The sum of elements in the array is calculated and the difference between the two is the missing number
     */
    private static int findMissingNumberWithNaturalSum(int[] arr) {
        int arrSum = 0;
        for (int j : arr) {
            arrSum += j;
        }

        int sumOfFirstNNaturalNumbers = arr.length * (arr.length + 1) / 2;

        return sumOfFirstNNaturalNumbers - arrSum;
    }

}
