package com.example.advanced.algorithms.kmp;

/**
 * KMP pattern match algorithm
 */
public class KMPPatternMatch {

    /**
     * compute LPS array for KMP algorith,
     * Longest Prefix suffix array
     *
     * @param pattern
     * @return
     */
    public int[] computeLPSArray(char[] pattern) {
        int[] lps = new int[pattern.length];
        lps[0] = 0;
        int index = 0;

        for (int i = 1; i < pattern.length; ) {
            if (pattern[i] == pattern[index]) {
                lps[i] = index + 1;
                index++;
                i++;
            } else {
                if (index != 0) {
                    index = lps[index - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;

    }

    /**
     * Knuth Morris Pratt Algorithm
     *
     * @param text
     * @param pattern
     * @return
     */
    public int searchPattern(char[] text, char[] pattern) {
        int[] lps = computeLPSArray(pattern);

        int i = 0;
        int j = 0;
        while (i < text.length && j < pattern.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        if (j == pattern.length) {
            return (i - j);
        }
        return -1;
    }
}
