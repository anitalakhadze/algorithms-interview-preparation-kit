package org.example.string;

public class IsRotationOfPalindrome {

    public static void main(String[] args) {
        String str = "aab";
        assert isRotationOfPalindrome(str);
    }

    private static boolean isRotationOfPalindrome(String str) {
        if (isPalindrome(str)) {
            return true;
        }

        for (int i = 0; i < str.length() - 1; i++) {
            String str1 = str.substring(i + 1);
            String str2 = str.substring(0, i + 1);
            if (isPalindrome(str1 + str2)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;

        while(right > left) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }

        return true;
    }

}
