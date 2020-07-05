package com.practice.interviewbit.dynamic;

import java.util.Arrays;

public class ScrambledString {

    public int isScramble(final String a, final String b) {
        if (a.length() != b.length()) {
            return 0;
        }
        int n = a.length();
        if (n == 0) {
            return 1;
        }
        if (a.equals(b)) {
            return 1;
        }

        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(b1);
        if (!new String(a1).equals(new String(b1))) {
            return 0;
        }


        for (int i = 1; i < n; i++) {
            if (isScramble(a.substring(0, i), b.substring(0, i)) == 1 &&
                    isScramble(a.substring(i, n), b.substring(i, n)) == 1) {
                return 1;
            }
            if (isScramble(a.substring(0, n - i), b.substring(i, n)) == 1 &&
                    isScramble(a.substring(n - i, n), b.substring(0, i)) == 1) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new ScrambledString().isScramble("great", "rgtae"));
    }
}
