package com.example.advanced.algorithms.boyermoore;

/**
 * Boyer Moore Horsepool pattern match algorithm
 */
public class BoyerMooreHorsePatternMatch {

    private final int ASCII_TABLE_SIZE = 256;

    /**
     * search pattern using boyer moore
     *
     * @param text
     * @param pattern
     * @return
     */
    public int searchPattern(char[] text, char[] pattern) {
        if (pattern == null || pattern.length == 0) {
            return 0;
        }
        if (text == null) {
            return -1;
        }
        int[] table = preprocessTable(pattern);

        for (int i = pattern.length - 1; i < text.length; ) {
            for (int j = pattern.length - 1; pattern[j] == text[i]; i--, j--) {
                if (j == 0) {
                    return i;
                }
            }
            i = i + table[text[i]];
        }

        return -1;
    }

    /**
     * create bad character table.
     * It will add pattern length to every position that is not in the pattern.
     * It will also add pattern.length at last position if it in unique
     * <p>
     * max(1, p.length-index-1)
     * <p>
     * tes as in test >>> check last character is duplicate if recalculate first t
     * 321 -> 121
     * <p>
     * ab* as in abc
     * 213
     *
     * @param pattern
     * @return
     */
    public int[] preprocessTable(char[] pattern) {
        int[] table = new int[ASCII_TABLE_SIZE];
        for (int i = 0; i < ASCII_TABLE_SIZE; i++) {
            table[i] = pattern.length;
        }
        for (int i = 0; i < pattern.length - 1; i++) {
            table[pattern[i]] = Math.max(1, pattern.length - i - 1);
        }
        if (table[pattern[pattern.length - 1]] < pattern.length) {
            table[pattern[pattern.length - 1]] = 1; // always pattern.length-index-1 == 0(test 4-3-1)
        }
        return table;
    }
}
