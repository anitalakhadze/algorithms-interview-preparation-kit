package org.example.string;

public class LongestRepeatingSubSequence {

    public static void main(String[] args) {
        String str = "aabebcdd";
        assert longestRepeatingSubSequence(str) == 3;
    }

    private static int longestRepeatingSubSequence(String str) {
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // if characters match and the indexes are not the same
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];    // add 1 to the previous value
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);    // get the maximum of the two values
                }
            }
        }

        return dp[n][n];
    }

}
