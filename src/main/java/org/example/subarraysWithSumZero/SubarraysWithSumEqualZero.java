package org.example.subarraysWithSumZero;

import java.util.List;

public class SubarraysWithSumEqualZero {
    public static int calcNumberOfSubArraysWithSumEqualsZero(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        int counter = 0;
        for (int i = 1; i <= numbers.size(); i++) {
            counter += findArrayWithSumZeroForFixedLength(numbers, i);
        }
        return counter;
    }

    // function which counts all possible elements of fixed lenght = 2,3,4,5...N where N - lenght of array
    private static int findArrayWithSumZeroForFixedLength(List<Integer> numbers, int length) {
        int counter = 0;
        for (int i = 0; i < numbers.size() - (length-1); i++) {
            int sum = numbers.subList(i, (i + length)).stream().mapToInt(Integer::intValue).sum();
            if (sum == 0) {
                counter++;
            }
        }
        return counter;
    }

}
