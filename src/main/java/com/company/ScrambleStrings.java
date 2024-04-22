package com.company;

import java.util.ArrayList;
import java.util.List;

public class ScrambleStrings {
    public static List<String> scrambleStrings(int left, int right, List<String> strings) {
        List<String> result = new ArrayList<>();
        StringBuilder word;
        int j, length;
        char letter;

        if(right <= left)
            throw new IllegalArgumentException("Right interval bound is less than equal to the left one.");

        for (String string : strings) {
            word = new StringBuilder(string);
            length = word.length();

            if (length >= left && length <= right) {
                for (j = 0; j < length; j++) {
                    letter = word.charAt(j);

                    if ((letter >= 'a' && letter <= 'm') || (letter >= 'A' && letter <= 'M')) letter += 13;
                    else letter -= 13;

                    word.setCharAt(j, letter);
                }
            } else {
                j = 0;

                do {
                    if (j % 2 == 0)
                        word.setCharAt(j, Character.toLowerCase(word.charAt(j)));
                    else
                        word.setCharAt(j, Character.toUpperCase(word.charAt(j)));

                    j++;
                } while (j < strings.size() - 1);
            }

            result.add(word.toString());
            word.setLength(0);
        }

        return result;
    }
}
