package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScrambleStringsTest {
    ScrambleStrings obj = new ScrambleStrings();

    @Test
    public void lineCoverage() {
        assertEquals(
                Arrays.asList("gvtre", "ryrc&nag", "tvenss$f", "mroen", "jbys", "sUpErDuPeRaNiMal"),
                obj.scrambleStrings(0, 8,
                        Arrays.asList("tiger", "elep3ant", "giraff6s", "zebra", "wolf", "superduperanimal")
                )
        );

        assertThrows(IllegalArgumentException.class,
                () -> obj.scrambleStrings(6, 4,
                        Arrays.asList("tiger", "ryrcunag", "tvenssr", "zebra", "wolf")
                )
        );
        assertThrows(IllegalArgumentException.class,
                () -> obj.scrambleStrings(4, 4,
                        Arrays.asList("tiger", "ryrcunag", "tvenssr", "zebra", "wolf")
                )
        );
        assertThrows(IllegalArgumentException.class,
                () -> obj.scrambleStrings(-1, 5,
                        Arrays.asList("tiger", "ryrcunag", "tvenssr", "zebra", "wolf")
                )
        );
        assertThrows(IllegalArgumentException.class,
                () -> obj.scrambleStrings(6, 0,
                        Arrays.asList("tiger", "ryrcunag", "tvenssr", "zebra", "wolf")
                )
        );
        assertThrows(NullPointerException.class,
                () -> obj.scrambleStrings(6, 8, null)
        );
        assertThrows(IllegalArgumentException.class,
                () -> obj.scrambleStrings(6, 8, List.of())
        );
    }
}
