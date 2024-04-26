package org.example.subarraysWithSumZero;

import org.example.noteMagazine.NoteMagazine;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SubarraysWithSumEqualZeroTest {
    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("Empty list", List.of(), 0),
                Arguments.of("One element list [1]", List.of(1), 0),
                Arguments.of("One element list [0]", List.of(0), 1),
                Arguments.of("2 element list [0, 0]", List.of(0, 0), 3),
                Arguments.of("3 elements list: [0,1-1,0]", List.of(0,1,-1), 3),
                Arguments.of("4 elements list", List.of(1,2,-2,-1), 2)
        );
    }

    @ParameterizedTest(name = "[{index}] - {0}")
    @MethodSource("testCases")
    void shouldThrowImproperStatusException_whenStarNewGameWithImproperStatus(String testCaseDescription, List<Integer> numbers, int expectedResult) {
        assertEquals(expectedResult, SubarraysWithSumEqualZero.calcNumberOfSubArraysWithSumEqualsZero(numbers));
    }


}