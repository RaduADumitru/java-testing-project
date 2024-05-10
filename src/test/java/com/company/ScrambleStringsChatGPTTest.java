package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScrambleStringsChatGPTTest {
    @Test
    void scrambleStrings_validInputs() {
        List<String> input = Arrays.asList("Hello", "123", "abc", "WXYZ");
        List<String> expected = Arrays.asList("hElLo", "&$&", "nop", "JKLM");
        List<String> result = ScrambleStrings.scrambleStrings(1, 4, input);
        assertEquals(expected, result);
    }

    @Test
    void scrambleStrings_leftRightEqual() {
        List<String> input = Arrays.asList("Hello", "123", "abc", "WXYZ");
        assertThrows(IllegalArgumentException.class, () -> ScrambleStrings.scrambleStrings(3, 3, input));
    }

    @Test
    void scrambleStrings_rightLessThanLeft() {
        List<String> input = Arrays.asList("Hello", "123", "abc", "WXYZ");
        assertThrows(IllegalArgumentException.class, () -> ScrambleStrings.scrambleStrings(4, 1, input));
    }

    @Test
    void scrambleStrings_negativeBounds() {
        List<String> input = Arrays.asList("Hello", "123", "abc", "WXYZ");
        assertThrows(IllegalArgumentException.class, () -> ScrambleStrings.scrambleStrings(-1, 4, input));
    }

    @Test
    void scrambleStrings_nullInput() {
        assertThrows(NullPointerException.class, () -> ScrambleStrings.scrambleStrings(1, 4, null));
    }

    @Test
    void scrambleStrings_emptyInput() {
        List<String> input = List.of();
        assertThrows(IllegalArgumentException.class, () -> ScrambleStrings.scrambleStrings(1, 4, input));
    }
}
