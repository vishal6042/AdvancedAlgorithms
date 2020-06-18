package com.practice.interviewbit.strings;

/**
 * https://www.interviewbit.com/problems/minimum-characters-required-to-make-a-string-palindromic/
 * <p>
 * Given an string A. The only operation allowed is to insert characters in the beginning of the string.
 * <p>
 * Find how many minimum characters are needed to be inserted to make the string a palindrome string.
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The only argument given is string A.
 * Output Format
 * <p>
 * Return the minimum characters that are needed to be inserted to make the string a palindrome string.
 * For Example
 * <p>
 * Input 1:
 * A = "ABC"
 * Output 1:
 * 2
 * Explanation 1:
 * Insert 'B' at beginning, string becomes: "BABC".
 * Insert 'C' at beginning, string becomes: "CBABC".
 * <p>
 * Input 2:
 * A = "AACECAAAA"
 * Output 2:
 * 2
 * Explanation 2:
 * Insert 'A' at beginning, string becomes: "AAACECAAAA".
 * Insert 'A' at beginning, string becomes: "AAAACECAAAA".
 */

public class MinCharPalindrome {

    public static void main(String[] args) {
        MinCharPalindrome mcp = new MinCharPalindrome();
        System.out.println(mcp.solve("AACECAAAA"));
    }

    public int solve(String A) {
        if (A.length() == 1) {
            return 0;
        }
        if (A.length() == 2) {
            if (A.charAt(0) == A.charAt(1)) {
                return 0;
            } else {
                return 1;
            }
        }

        StringBuilder builder = new StringBuilder();
        builder.append(A);
        String reverse = builder.reverse().toString();
        builder.reverse().append("$").append(reverse);
        int lps[] = computeLPSArray(builder.toString());
        return A.length() - lps[builder.length() - 1];

    }

    public int[] computeLPSArray(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        lps[0] = 0;
        int index = 0;

        for (int i = 1; i < n; ) {
            if (pattern.charAt(i) == pattern.charAt(index)) {
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
