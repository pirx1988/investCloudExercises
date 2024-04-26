package org.example.FindSumIndices;

import java.util.List;

/**
 * Given an array of integers numbers and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * Examples:
 * Numbers = [1,2,4,5]
 * Target = 3
 * Return [0,1]
 * Numbers = [3,2,4]
 * Target = 6
 * Return [1,2]
 **/

public class FindSumOfIndices {
    public static List<Integer> calcTarget(List<Integer> numbers, int target) {
        if (numbers.size() == 0) {
            return List.of();
        }
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                System.out.println("i = " + i + ", j = " + j);
                if ((numbers.get(i) + numbers.get(j)) == target) {
                    return List.of(i, j);
                }
            }
        }
        return List.of();

    }
}
