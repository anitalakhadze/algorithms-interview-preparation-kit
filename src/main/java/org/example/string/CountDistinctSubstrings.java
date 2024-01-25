package org.example.string;

import java.util.Set;

public class CountDistinctSubstrings {

    public static void main(String[] args) {
        String str = "ababa";
        assert countDistinctSubstrings(str) == 10;
    }

    private static int countDistinctSubstrings(String str) {
        Set<String> set = new java.util.HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                set.add(str.substring(i, j)); // we can optimize the space by using append instead of substring
            }
        }

        return set.size();
    }

}
