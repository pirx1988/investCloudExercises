package org.example.AllCombinationsWithSumZero;

import org.example.recursion.Combinations;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AllCombinationsWithSumZeroTest {
    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("Empty set", new int[]{}, 0),
                Arguments.of("{} -> 0", new int[]{}, 0),
                Arguments.of("{-1} -> 0", new int[]{-1}, 0),
                Arguments.of("{0} -> ", new int[]{0}, 1),
                Arguments.of("{1,0,-1,0}", new int[]{1, 0, -1, 0}, 2)
        );
    }

    @ParameterizedTest(name = "[{index}] - {0}")
    @MethodSource("testCases")
    void shouldCalcAllPossibleSums(String testCaseDescription, int[] array, int expectedNumberOfSums) {
        assertEquals(expectedNumberOfSums, AllCombinationsWithSumZero.allCombinationsWithSumEqualsZero(array));
    }

}
// Use cases:
//1) IF I pass empty array -> 0
//2) IF I pass [0] -> 1, [1] -> 0
//3) IF I pass 2 elements equals [0,0] -> 3
//if I  I pass 3 elements equals [0,0,0] : [0] -> 1, [0] -> 1, [0] -> 1, [0,0] -> 1, [0,0] -> 1, [0,0] ->1, [0,0,0] -> 1