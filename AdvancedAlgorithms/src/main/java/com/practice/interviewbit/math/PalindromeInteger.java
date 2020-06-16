package com.practice.interviewbit.math;

/**
 * https://www.interviewbit.com/problems/palindrome-integer/
 * <p>
 * Determine whether an integer is a palindrome. Do this without extra space.
 * <p>
 * A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
 * Negative numbers are not palindromic.
 * <p>
 * Example :
 * <p>
 * Input : 12121
 * Output : True
 * <p>
 * Input : 123
 * Output : False
 */
public class PalindromeInteger {

    public static void main(String[] args) {
        PalindromeInteger pi = new PalindromeInteger();
        System.out.println(pi.isPalindrome(12121));
        System.out.println(pi.isPalindrome(1234321));
        System.out.println(pi.isPalindrome(12343));
        System.out.println(pi.isPalindrome(746787647));
    }

    public int isPalindrome(int A) {

        long val = A;
        long newNo = 0;
        while (A > 0) {
            int rem = A % 10;
            newNo = newNo * 10 + rem;
            A = A / 10;
        }
        return (newNo == val) ? 1 : 0;
    }
}
