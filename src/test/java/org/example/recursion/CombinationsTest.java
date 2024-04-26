package org.example.recursion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CombinationsTest {
    private static Stream<Arguments> testCases() {
        return Stream.of(
//                Arguments.of("Empty set", new int[]{}, List.of()),
                Arguments.of("{1,2}", new int[]{1, 2}, List.of(
                        List.of(),
                        List.of(1),
                        List.of(2),
                        List.of(1, 2)
                )),
                Arguments.of("Test 1", new int[]{42}, List.of(List.of(), List.of(42))),
                Arguments.of("Test 2", new int[]{1, 2, 3}, List.of(
                        List.of(),
                        List.of(1),
                        List.of(2),
                        List.of(3),
                        List.of(1, 2),
                        List.of(2, 3),
                        List.of(1, 3),
                        List.of(1, 2, 3)
                ))
        );
    }

    @ParameterizedTest(name = "[{index}] - {0}")
    @MethodSource("testCases")
    void shouldCorrectlyCalcSmallestWindow(String testCaseDescription, int[] set, List<List<Integer>> expectedResult) {
        assertThat(expectedResult).hasSameElementsAs(Combinations.getAllSubsets(set));
    }

}