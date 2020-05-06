package com.example.advanced.algorithms.zalgo;

import java.util.Arrays;

/**
 * Z pattern algorithm for pattern searching
 */
public class ZPatternMatchAlgorithm {

    private static final char SEPARATOR = '$';

    public int searchPattern(char[] text, char[] pattern) {

        int z[] = prepareZTable(text, pattern);
        for (int i = 0; i < z.length; i++) {
            if (z[i] == pattern.length) {
                return (i - pattern.length - 1);
            }
        }
        return -1;
    }

    public int[] searchAllPattern(char[] text, char[] pattern) {
        int[] result = new int[text.length];
        Arrays.fill(result, -1);
        int index = 0;

        int[] z = prepareZTable(text, pattern);
        for (int i = 0; i < z.length; i++) {
            if (z[i] == pattern.length) {
                result[index++] = (i - pattern.length - 1);
            }
        }
        return result;
    }

    /**
     * pattern = abc
     * text = abdbchabcd
     * ztable text = abc$abdbchabcd 1 more than pattern + text length for $
     *
     * @param text
     * @param pattern
     * @return
     */
    public int[] prepareZTable(char[] text, char[] pattern) {
        int length = text.length + pattern.length + 1;
        int[] table = new int[length];
        Arrays.fill(table, 0);
        char[] mergedString = createLongString(text, pattern);
        int left = 0; //start of pattern
        int right = 0; //start of text

        for (int i = 1; i < mergedString.length; i++) {
            if (i > right) {
                left = right = i;
                while (right < mergedString.length &&
                        mergedString[right - left] == mergedString[right]) {
                    right++;
                }
                table[i] = right - left;
                right--;
            } else {
                int k = i - left;
                if (table[k] < right - i + 1) {
                    table[i] = table[k];
                } else {
                    left = i;
                    while (right < mergedString.length &&
                            mergedString[right - left] == mergedString[right]) {
                        right++;
                    }
                    table[i] = right - left;
                    right--;
                }
            }
        }

        return table;
    }

    public char[] createLongString(char[] text, char[] pattern) {
        char[] mergedString = new char[text.length + pattern.length + 1];
        System.arraycopy(pattern, 0, mergedString, 0, pattern.length);
        mergedString[pattern.length] = SEPARATOR;
        System.arraycopy(text, 0, mergedString, pattern.length + 1, text.length);
        return mergedString;
    }
}
