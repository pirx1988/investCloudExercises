package org.example.FindSumIndices;

import org.example.noteMagazine.NoteMagazine;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FindSumOfIndicesTest {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("Test1", List.of(), 5, List.of()),
                Arguments.of("Test2", List.of(1, 2, 4, 5), 3, List.of(0, 1)),
                Arguments.of("Test3", List.of(3, 2, 4), 6, List.of(1, 2)),
                Arguments.of("Test4", List.of(0, 1, 2, 5), 5, List.of(0, 3)),
                Arguments.of("Test5", List.of(0, 1, 2, 5, 6), 11, List.of(3, 4))
        );
    }

    @ParameterizedTest(name = "[{index}] - {0}")
    @MethodSource("testCases")
    void shouldThrowImproperStatusException_whenStarNewGameWithImproperStatus(String testCaseDescription, List<Integer> numbers, int target, List<Integer> expectedResult) {
        assertEquals(expectedResult, FindSumOfIndices.calcTarget(numbers, target));
    }

}