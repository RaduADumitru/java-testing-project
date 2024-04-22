package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScrambleStringsTest {
    @Test
    public void statementCoverage() {
        List<String> actual = Arrays.asList("tiger", "elephant", "giraffe", "zebra", "wolf");
        List<String> expected = Arrays.asList("tIgEr", "ryrcunag", "tvenssr", "zEbRa", "wOlF");

        assertEquals(expected, ScrambleStrings.scrambleStrings(6, 8, actual));
        assertThrows(IllegalArgumentException.class, () -> ScrambleStrings.scrambleStrings(6, 4, actual));
    }
}
