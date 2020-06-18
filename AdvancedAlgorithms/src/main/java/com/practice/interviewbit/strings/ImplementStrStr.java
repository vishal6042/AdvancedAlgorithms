package com.practice.interviewbit.strings;

public class ImplementStrStr {

    public static void main(String[] args) {
        System.out.println(new ImplementStrStr().strStr("hello", "ellc"));
    }

    public int strStr(final String data, final String pattern) {
        if (pattern.isEmpty()) {
            return -1;
        }
        if (data.isEmpty()) {
            return -1;
        }
        int lps[] = calculateLps(pattern);
        int i = 0;
        int j = 0;

        while (i < data.length() && j < pattern.length()) {
            if (data.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    j = 0;
                    i++;
                }
            }
        }
        if (j == pattern.length()) {
            return (i - j);
        }
        return -1;
    }

    private int[] calculateLps(String pattern) {
        int[] lps = new int[pattern.length()];
        int index = 0;
        lps[0] = 0;

        for (int i = 1; i < pattern.length(); i++) {
            if (pattern.charAt(i - 1) == pattern.charAt(i)) {
                index++;
                lps[i] = index;
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
}
