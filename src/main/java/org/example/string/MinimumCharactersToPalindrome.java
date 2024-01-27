package org.example.string;

public class MinimumCharactersToPalindrome {

    public static void main(String[] args) {
        String str = "AACECAAAA";
        assert minimumCharactersToPalindrome(str) == 2;
    }

    private static int minimumCharactersToPalindrome(String str) {
        int n = str.length();
        int start = 0;
        int end = n - 1;
        int result = 0;

        while (start < end) {
            if (str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            } else {
                result++;
                start = 0;
                end = n - result - 1;
            }
        }

        return result;
    }

}
