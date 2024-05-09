package com.company;

import java.util.ArrayList;
import java.util.List;

public class ScrambleStrings {
    public static List<String> scrambleStrings(int left, int right, List<String> strings) {
        List<String> result = new ArrayList<>();
        int j, length;
        char letter;

        if (right < 0 || left < 0) // 1
            throw new IllegalArgumentException("One of the interval bounds is negative."); // 2

        if (right <= left) // 3
            throw new IllegalArgumentException("Right interval bound is less than equal to the left one."); // 4

        if (strings == null) // 5
            throw new NullPointerException("String list is null."); // 6
        if (strings.isEmpty()) // 7
            throw new IllegalArgumentException("String list is empty."); // 8

        for (String string : strings) { // 9
            StringBuilder word = new StringBuilder(string);
            length = word.length(); // 10

            if (length >= left && length <= right) { // 11
                for (j = 0; j < length; j++) { // 12
                    letter = string.charAt(j); // 13

                    if(Character.isDigit(letter)) { // 14
                        if((letter - '0') % 2 == 0) // 15
                            word.setCharAt(j, '$'); // 16
                        else // 17
                            word.setCharAt(j, '&'); // 18
                    } else { // 19
                        if ((letter >= 'a' && letter <= 'm') || (letter >= 'A' && letter <= 'M')) // 20
                            letter += 13; // 21
                        else // 22
                            letter -= 13; // 23

                        word.setCharAt(j, letter); // 24
                    }
                }
            } else if (length > right) { // 25
                j = 0; // 26

                do { // 27
                    if (j % 2 == 0) // 28
                        word.setCharAt(j, Character.toLowerCase(word.charAt(j))); // 29
                    else // 30
                        word.setCharAt(j, Character.toUpperCase(word.charAt(j))); // 31

                    j++; // 32
                } while (j < length - 1); // 33
            }

            result.add(word.toString()); // 34
            word.setLength(0); // 35
        }

        return result; // 36
    }
}
