package org.example.SmallestWindow;

import org.example.FindSumIndices.FindSumOfIndices;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SmallestWindowTest {
    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("Test 1", "", "", ""),
                Arguments.of("Test 2", "", "aa", ""),
                Arguments.of("Test 3", "aa", "", ""),
                Arguments.of("Test 4", "toc", "alibaba", ""),
                Arguments.of("Test 5", "timetopractise", "toc", "toprac"),
                Arguments.of("Test 6", "fffaaccffffac", "c", "c")
        );
    }

    @ParameterizedTest(name = "[{index}] - {0}")
    @MethodSource("testCases")
    void shouldCorrectlyCalcSmallestWindow(String testCaseDescription, String s, String p, String expectedResult) {
        assertEquals(expectedResult, SmallestWindow.findSmallestWindow(s, p));
    }
}