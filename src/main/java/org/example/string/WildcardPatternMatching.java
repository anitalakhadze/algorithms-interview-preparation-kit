package org.example.string;

public class WildcardPatternMatching {

    public static void main(String[] args) {
        String str = "baaabab";
        assert wildcardPatternMatching(str, "*****ba*****ab");
        assert wildcardPatternMatching(str, "baaa?ab");
        assert wildcardPatternMatching(str, "ba*a?");
        assert !wildcardPatternMatching(str, "a*ab");
    }

    private static boolean wildcardPatternMatching(String str, String pattern) {
        int sIdx = 0, pIdx = 0;
        int lastWildcardIdx = -1, sBacktrackIdx = -1, nextToWildcardIdx = -1;

        while (sIdx < str.length()) {
            if (pIdx < pattern.length() && (pattern.charAt(pIdx) == '?' || pattern.charAt(pIdx) == str.charAt(sIdx))) {
                // if the characters match or the pattern has a '?', move to the next character
                sIdx++;
                pIdx++;
            } else if (pIdx < pattern.length() && pattern.charAt(pIdx) == '*') {
                // wildcard found, save the index of the wildcard
                lastWildcardIdx = pIdx;
                nextToWildcardIdx = ++pIdx; // save the index of the next character after the wildcard
                sBacktrackIdx = sIdx;   // save the index of the string where the backtrack will start
            } else if (lastWildcardIdx == -1) {
                // no wildcard found and the characters don't match
                return false;
            } else {
                // backtrack - no match found, but there is a previous wildcard
                pIdx = nextToWildcardIdx; // move the pattern index to the next character after the wildcard
                sIdx = ++sBacktrackIdx; // move the string index to the next character after the backtrack index
            }
        }

        for (int i = pIdx; i < pattern.length(); i++) {
            if (pattern.charAt(i) != '*') {
                return false;   // if there are still characters left in the pattern, but no more characters in the string
            }
        }

        return true;
    }

}
