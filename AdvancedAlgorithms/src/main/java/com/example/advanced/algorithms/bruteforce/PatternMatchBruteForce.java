package com.example.advanced.algorithms.bruteforce;

import java.util.Arrays;

/**
 * PatternMatching algorithm using brute force
 */
public class PatternMatchBruteForce {

    /**
     * Return 1st index of pattern in arr
     * return -1 if no match
     *
     * @param arr
     * @param pattern
     * @return
     */
    public int findFirstMatch(char[] arr, char[] pattern) {
        for (int i = 0; i <= arr.length - pattern.length; ++i) {
            for (int p = 0; p < pattern.length; ++p) {
                if (arr[i + p] != pattern[p]) {
                    break;
                }
                if (p == pattern.length - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * return all index of pattern in the array
     *
     * @param arr
     * @param pattern
     * @return
     */
    public int[] findAllMatch(char[] arr, char[] pattern) {
        int[] indices = new int[arr.length - pattern.length + 1];
        Arrays.fill(indices, -1);
        int index = 0;
        for (int i = 0; i <= arr.length - pattern.length; ++i) {
            for (int p = 0; p < pattern.length; ++p) {
                if (arr[i + p] != pattern[p]) {
                    break;
                }
                if (p == pattern.length - 1) {
                    indices[index++] = i;
                }
            }
        }
        return indices;
    }
}
