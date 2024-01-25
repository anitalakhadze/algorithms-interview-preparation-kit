package org.example.string;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseWords {

    public static void main(String[] args) {
        String str = "I like this   program very much";
        System.out.println(reverseWords(str));
        assert reverseWords(str).equals("much very program   this like I");
    }

    private static String reverseWords(String str) {
        Queue<String> queue = new LinkedList<>();

        int endIdx = str.length();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                if (str.charAt(i + 1) != ' ') {
                    queue.add(str.substring(i + 1, endIdx));
                    endIdx = i;
                }
            }
        }

        // print queue
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
            sb.append(" ");
        }

        return sb.toString().trim();
    }

}
