package org.example.noteMagazine;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NoteMagazineTest {
    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("Test1", "a", "bcd", false),
                Arguments.of("Test2", "aa", "abc", false),
                Arguments.of("Test3", "", "abc", false),
                Arguments.of("Test3", "ssss", "", false),
                Arguments.of("Not enough words required", "aaaa", "baba", false)
        );
    }

    @ParameterizedTest(name = "[{index}] - {0}")
    @MethodSource("testCases")
    void shouldThrowImproperStatusException_whenStarNewGameWithImproperStatus(String testCaseDescription, String note, String magazine, boolean expectedResult) {
         assertEquals(expectedResult, NoteMagazine.checkIfConstructionPossible(note, magazine));
    }
}