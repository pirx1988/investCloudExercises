package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequencesString {
    public static void main(String[] args) {
        List<String> al = new ArrayList<>();
        String s = "abcd";

        findSubsequences(s, "", al); // Calling a function

        // Print each element on a new line
        for (String str : al) {
            System.out.println(str);
        }
    }

    private static void findSubsequences(String s, String ans, List<String> al) {
        if(s.length() == 0) {
            al.add(ans);
            return;
        }

        // we add adding 1st character in string
        findSubsequences(s.substring(1), ans +s.charAt(0), al);

        // Not adding first character of the string
        // because the concept of subsequence either
        // character will present or
        findSubsequences(s.substring(1), ans, al);
    }
}
