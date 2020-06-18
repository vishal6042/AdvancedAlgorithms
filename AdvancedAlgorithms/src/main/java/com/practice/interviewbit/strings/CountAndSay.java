package com.practice.interviewbit.strings;

/**
 * https://www.interviewbit.com/problems/count-and-say/
 * <p>
 * he count-and-say sequence is the sequence of integers beginning as follows:
 * <p>
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as one 1 or 11.
 * 11 is read off as two 1s or 21.
 * <p>
 * 21 is read off as one 2, then one 1 or 1211.
 * <p>
 * Given an integer n, generate the nth sequence.
 * <p>
 * Note: The sequence of integers will be represented as a string.
 * <p>
 * Example:
 * <p>
 * if n = 2,
 * the sequence is 11.
 */
public class CountAndSay {
    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(5));
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String prev = "1";
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i < n; i++) {

            int count = 1;
            for (int j = 0; j < prev.length(); j++) {
                if (j + 1 < prev.length() && prev.charAt(j + 1) == prev.charAt(j)) {
                    count++;
                } else {
                    ans.append(count);
                    ans.append(prev.charAt(j));
                    count = 1;
                }
            }
            prev = ans.toString();
            ans = new StringBuilder();
        }
        return prev;

    }
}
