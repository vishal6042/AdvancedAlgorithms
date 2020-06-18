package com.practice.interviewbit.strings;

/**
 * https://www.interviewbit.com/problems/palindrome-string/
 * <p>
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * Example:
 * <p>
 * "A man, a plan, a canal: Panama" is a palindrome.
 * <p>
 * "race a car" is not a palindrome.
 * <p>
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class PalindromeChecker {

    public static void main(String[] args) {
        PalindromeChecker pc = new PalindromeChecker();
        System.out.println(pc.isPalindrome("race a car"));
    }

    public int isPalindrome(String a) {
        if (a == null) {
            return 0;
        }
        if (a.length() == 1) {
            return 1;
        }
        a = a.toLowerCase();
        int i = 0;
        int j = a.length() - 1;
        while (i <= j) {
            char s = a.charAt(i);
            char e = a.charAt(j);
            if (isValid(s) && isValid(e)) {
                if (s != e) {
                    return 0;
                }
                i++;
                j--;
            } else if (isValid(s)) {
                j--;
            } else {
                i++;
            }

        }
        return 1;
    }

    private boolean isValid(char s) {
        return (s >= '0' && s <= '9') || (s >= 'a' && s <= 'z') || (s >= 'A' && s <= 'Z');
    }
}
