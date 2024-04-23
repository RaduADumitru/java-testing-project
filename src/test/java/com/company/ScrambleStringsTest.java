package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScrambleStringsTest {
    @Test
    public void lineCoverage() {
        assertEquals(
            Arrays.asList("tiger", "ryrcunag", "tvenssr", "zebra", "wolf"),
            ScrambleStrings.scrambleStrings(6, 8,
                Arrays.asList("tiger", "elephant", "giraffe", "zebra", "wolf")
            )
        );
        assertEquals(
                Arrays.asList("tiger", "ryrc&nag", "tvenss$f", "zebra", "wolf"),
            ScrambleStrings.scrambleStrings(6, 8,
                Arrays.asList("tiger", "elep3ant", "giraff6s", "zebra", "wolf")
            )
        );
        assertEquals(
            Arrays.asList("tiger", "ryrc&nag", "tvenss$f", "zebra", "wolf", "sUpErDuPeRaNiMal"),
            ScrambleStrings.scrambleStrings(6, 8,
                    Arrays.asList("tiger", "elep3ant", "giraff6s", "zebra", "wolf", "superduperanimal")
            )
        );

        assertThrows(IllegalArgumentException.class,
            () -> ScrambleStrings.scrambleStrings(6, 4,
                Arrays.asList("tiger", "ryrcunag", "tvenssr", "zebra", "wolf")
            )
        );
        assertThrows(IllegalArgumentException.class,
            () -> ScrambleStrings.scrambleStrings(-1, 5,
                    Arrays.asList("tiger", "ryrcunag", "tvenssr", "zebra", "wolf")
            )
        );
        assertThrows(NullPointerException.class,
            () -> ScrambleStrings.scrambleStrings(6, 8, null)
        );
        assertThrows(IllegalArgumentException.class,
            () -> ScrambleStrings.scrambleStrings(6, 8, List.of())
        );
    }
}
