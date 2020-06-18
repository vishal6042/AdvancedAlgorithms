package com.practice.interviewbit.strings;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix plc = new LongestCommonPrefix();
        String arr[] = {"abcd", "abcd", "efgh"};
        System.out.println(plc.longestCommonPrefix(arr));
    }

    public String longestCommonPrefix(String[] A) {
        if (A == null || A.length == 0) {
            return "";
        }

        String prefix = A[0];
        for (int i = 1; i < A.length; i++) {
            prefix = commonPrefix(prefix, A[i]);
        }
        return prefix;

    }

    private String commonPrefix(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        StringBuilder prefix = new StringBuilder();
        for (int i = 0, j = 0; i < n1 && j < n2; i++, j++) {
            if (s1.charAt(i) != s2.charAt(j)) {
                break;
            }
            prefix.append(s1.charAt(i));

        }
        return prefix.toString();
    }
}
