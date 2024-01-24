package org.example.string;

import java.util.Arrays;

public class MinimumEditOperations {

    public static void main(String[] args) {
        String str1 = "saturday";
        String str2 = "sunday";
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        Arrays.fill(dp[0], 0);
        assert minimumEditOperations(str1, str2, n, m, dp) == 3;
    }


    // using dynamic programming (memoization)
    private static int minimumEditOperations(String str1, String str2, int n, int m, int[][] dp) {
        if (n == 0) {
            return m;  // if the first string is empty, the minimum number of operations is the length of the second string
        }

        if (m == 0) {
            return n;   // if the second string is empty, the minimum number of operations is the length of the first string
        }

        if (dp[n][m] != -1) {
            return dp[n][m];    // if the value is already calculated, return it
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return dp[n][m] = minimumEditOperations(str1, str2, n - 1, m - 1, dp);
            // if the last characters are equal, ignore them and calculate the minimum number of operations for the rest of the strings
        } else {
            int insert = minimumEditOperations(str1, str2, n, m - 1, dp); // insert a character
            int remove = minimumEditOperations(str1, str2, n - 1, m, dp); // remove a character
            int replace = minimumEditOperations(str1, str2, n - 1, m - 1, dp); // replace a character
            return dp[n][m] = 1 + Math.min(insert, Math.min(remove, replace)); // return the minimum of the three operations
        }
    }

}
