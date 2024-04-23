package com.company;

import java.util.ArrayList;
import java.util.List;

public class ScrambleStrings {
    public static List<String> scrambleStrings(int left, int right, List<String> strings) {
        List<String> result = new ArrayList<>();
        int j, length;
        char letter;

        if (right < 0 || left < 0)
            throw new IllegalArgumentException("One of the interval bounds is negative.");

        if (right <= left)
            throw new IllegalArgumentException("Right interval bound is less than equal to the left one.");

        if (strings == null)
            throw new NullPointerException("String list is null.");
        if (strings.isEmpty())
            throw new IllegalArgumentException("String list is empty.");

        for (String string : strings) {
            StringBuilder word = new StringBuilder(string);
            length = word.length();

            if (length >= left && length <= right) {
                for (j = 0; j < length; j++) {
                    letter = string.charAt(j);

                    if(Character.isDigit(letter)) {
                        if((letter - '0') % 2 == 0)
                            word.setCharAt(j, '$');
                        else
                            word.setCharAt(j, '&');
                    } else {
                        if ((letter >= 'a' && letter <= 'm') || (letter >= 'A' && letter <= 'M')) letter += 13;
                        else letter -= 13;

                        word.setCharAt(j, letter);
                    }
                }
            } else if (length > right) {
                j = 0;

                do {
                    if (j % 2 == 0)
                        word.setCharAt(j, Character.toLowerCase(word.charAt(j)));
                    else
                        word.setCharAt(j, Character.toUpperCase(word.charAt(j)));

                    j++;
                } while (j < length - 1);
            }

            result.add(word.toString());
            word.setLength(0);
        }

        return result;
    }
}
