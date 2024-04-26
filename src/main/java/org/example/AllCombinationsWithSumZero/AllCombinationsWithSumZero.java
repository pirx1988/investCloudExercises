package org.example.AllCombinationsWithSumZero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Zero Sum Subarrays :
 * You are given an array A[] of size N. Find the total count of sub-arrays having their sum equal to 0.
 * Example 1:
 * Input:
 * A[] = {0,0,5,5,0,0}
 * Output: 13
 * Explanation: The 13 subarrays are
 * [0], [0], [0], [0], [0,0], and [0,0].
 * 1 - 4
 * 2 - 6
 * 3 - 2
 * 4 - 1
 * You don't need to read input or print anything. Complete the function findSubarray()
 * that takes the array A and its size N as input parameters and returns the total number of sub-arrays with 0 sum.
 **/
public class AllCombinationsWithSumZero {

    public static void main(String[] args) {
        List<List<Integer>> al = new ArrayList<>();
        int[] a = new int[] {1,0,-1};
        String s = "abcd";

        int numberOfSubsequences = findSubsequences(a, new ArrayList<>(), al, 0);// Calling a function

        // Print each element on a new line
        for (List<Integer> seq : al) {
            System.out.println(seq);
        }

        System.out.println("Number of subsequences: " + numberOfSubsequences);
    }

    private static int findSubsequences(int[] a, List<Integer> ans, List<List<Integer>> al, int numberOfsequences) {
        if (a.length == 0) {
            al.add(ans);
            if(!ans.isEmpty() && ans.stream().mapToInt(Integer::intValue).sum() == 0) {
                numberOfsequences++;
            }
            return numberOfsequences;
        }

        // we add adding 1st number from array
        List<Integer> newAns = new ArrayList<>(ans);
        newAns.add(a[0]);
        numberOfsequences = findSubsequences(Arrays.copyOfRange(a, 1, a.length), newAns, al, numberOfsequences);

        // Not adding first character of the string
        // because the concept of subsequence either
        // character will present or
        numberOfsequences = findSubsequences(Arrays.copyOfRange(a, 1, a.length), ans, al, numberOfsequences);

        return numberOfsequences;
    }



    public static int allCombinationsWithSumEqualsZero(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            if (array[0] == 0) {
                return 1;
            }
            return 0;
        }

        return calcPairsOfCombinationsForLengthAtLeastTwo(array, 0);
    }

    public static int calcPairsOfCombinationsForLengthAtLeastTwo(int[] array, int start) {
        int numOfPossibleSumsEqualZero = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if((array[i] + array[j]) == 0) {
                    numOfPossibleSumsEqualZero++;
                }
            }
        }
        return numOfPossibleSumsEqualZero;
    }
}
