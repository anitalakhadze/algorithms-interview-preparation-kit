package org.example.string;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        assert longestPalindromicSubstring(str).equals("geeksskeeg");
    }

    private static String longestPalindromicSubstring(String str) {
        int n = str.length();

        // Keeps track of the longest palindrome so far.
        // At first the longest palindromic substring is the first character
        int start = 0, end = 0;

        for (int i = 0; i < n; i++) {
            int len1 = expandFromCenter(str, i, i); // handles odd length palindromes
            int len2 = expandFromCenter(str, i, i + 1); // handles even length palindromes
            int len = Math.max(len1, len2); // get the longest palindrome length from the two
            if (len > end - start) { // if the new palindrome is longer than the current longest
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return str.substring(start, end + 1);
    }

    private static int expandFromCenter(String str, int left, int right) {
        // expand from the center until the left and right characters are not equal
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }

        // return the length of the palindrome
        return right - left - 1;
    }

}
