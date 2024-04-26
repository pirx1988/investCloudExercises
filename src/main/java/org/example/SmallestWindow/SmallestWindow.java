package org.example.SmallestWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Friday Given two strings. Find the smallest window... by Iliya ZakharcheniaFriday 18:50Iliya Zakharchenia
 * Given two strings. Find the smallest window in the first string consisting of all the characters of the second string.
 * Example 1:
 * Input:
 * S = timetopractice
 * P = toc
 * Output: toprac
 * Explanation: toprac is the smallest
 * subset in which toc can be found.
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function smallestWindow() which takes two string S and P as inputs and returns
 * the smallest window in string S having all the characters of the string P. In case there are multiple such windows of same length, return the one
 * with the least starting index. Return "-1" in case there's no such window present.
 */
public class SmallestWindow {
    public static String findSmallestWindow(String s, String p) {
        if(s.isEmpty() || p.isEmpty()) {
            return "";
        }
        if (p.length() == 1 && s.contains(String.valueOf(p.charAt(0)))) {
            return p;
        }

        int indexP = 0;
        int windowLength = s.length() + 1;
        int currentWindowLength;
        int startIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == p.charAt(indexP)) {
                currentWindowLength = calcParticularWindow(s.substring(i), p);
                if((currentWindowLength != 0) && (currentWindowLength < windowLength)) {
                    windowLength = currentWindowLength;
                    startIndex = i;
                }
            }
        }
        return startIndex == -1 ? "" : s.substring(startIndex, (startIndex + windowLength));
    }
    private static int calcParticularWindow(String substrS, String p) {

        int pIndex = 1;
        int pSize = p.length();
        int foundedLetters = 0;
        char letterInSubstrS;
        char letterInP;
        for (int sIndex = 1; sIndex < substrS.length(); sIndex++) {
            // get
            letterInSubstrS = substrS.charAt(sIndex); // o
            letterInP = p.charAt(pIndex);
            if(letterInSubstrS == letterInP) {
                pIndex++;
                foundedLetters++;
            }
            if(foundedLetters == (pSize - 1)) {
                return (sIndex + 1);
            }

        }
        return 0;
    }
}
