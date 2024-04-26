package org.example.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Combinations {


    public static List<List<Integer>> getAllSubsets(int[] set) {
        int length = set.length;
        if (length == 0) {
            return List.of();
        }
        // list of all solutions
        List<List<Integer>> possibleSubsets = new ArrayList<>(); // initialize empty set
        backTrack(possibleSubsets, new ArrayList<>(), set, 0);
        return possibleSubsets;
    }

    // you backtrack when you not pick an element
    private static void backTrack(List<List<Integer>> possibleSubsets, List<Integer> tempSet, int[] set, int start) {
        for (int i = start; i < set.length; i++) {
            // Case of including the number
            tempSet.add(set[i]); // add element 1

            // case of not-including the number
            backTrack(possibleSubsets, geTempSetWithoutPickedElement(tempSet, set[i]), set, i+1); // backtrack
        }
        possibleSubsets.add(tempSet);
    }

    private static List<Integer> geTempSetWithoutPickedElement(List<Integer> tempSet, int pickedElement) {
        return tempSet.stream().filter(x -> x != pickedElement).collect(Collectors.toList());
    }
}

