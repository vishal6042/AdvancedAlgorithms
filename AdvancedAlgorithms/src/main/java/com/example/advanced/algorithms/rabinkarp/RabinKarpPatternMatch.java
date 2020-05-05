package com.example.advanced.algorithms.rabinkarp;

/**
 * Rabin karp Algorithm
 */
public class RabinKarpPatternMatch {

    private static final int PRIME = 101;

    /**
     * return index of pattern from text
     *
     * @param text
     * @param pattern
     * @return
     */
    public int searchPattern(char[] text, char[] pattern) {
        int textLength = text.length;
        int patternLength = pattern.length;

        long patternHash = calculateHash(pattern, patternLength - 1);
        long textHash = calculateHash(text, patternLength - 1);
        for (int i = 0; i <= textLength - patternLength + 1; i++) {
            if (patternHash == textHash && isEquals(text, i, i + patternLength, pattern, patternLength)) {
                return i;
            }
            if (i < textLength - patternLength) {
                textHash = recalculateHash(text, textHash, i, i + patternLength , patternLength);
            }
        }
        return -1;

    }

    public long recalculateHash(char[] text, long textHash, int start, int end, int patternLength) {
        long newHash = textHash - text[start];
        newHash = newHash / PRIME;
        newHash += text[end] * Math.pow(PRIME, patternLength - 1);
        return newHash;

    }

    public boolean isEquals(char[] text, int start, int end,
                            char[] pattern, int patternEnd) {
        if ((end - start) != patternEnd) {
            return false;
        }
        for (int i = start, j = 0; i < end && j < patternEnd; i++, j++) {
            if (text[i] != pattern[j]) {
                return false;
            }
        }
        return true;
    }

    public long calculateHash(char[] arr, int length) {
        long hash = 0;
        for (int i = 0; i <= length; ++i) {
            hash += arr[i] * Math.pow(PRIME, i);
        }
        return hash;
    }
}
