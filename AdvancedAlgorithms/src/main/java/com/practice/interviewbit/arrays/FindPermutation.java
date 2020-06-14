package com.practice.interviewbit.arrays;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/find-permutation/
 * <p>
 * Given a positive integer n and a string s consisting only of letters D or I, you have to find any permutation of first n positive integer that satisfy the given input string.
 * <p>
 * D means the next number is smaller, while I means the next number is greater.
 * <p>
 * Notes
 * <p>
 * Length of given string s will always equal to n - 1
 * Your solution should run in linear time and space.
 * Example :
 * <p>
 * Input 1:
 * <p>
 * n = 3
 * <p>
 * s = ID
 * <p>
 * Return: [1, 3, 2]
 */
public class FindPermutation {

    public static void main(String[] args) {
        System.out.println(new FindPermutation().findPerm("DIDDDI", 7));
    }

    public ArrayList<Integer> findPerm(final String A, int B) {
        if (A == null || A.length() == 0) {
            return null;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int max = B;
        int min = 1;
        for (int i = 0; i < B - 1; i++) {
            if (A.charAt(i) == 'I') {
                ans.add(min++);
            } else {
                ans.add(max--);
            }
        }
        ans.add(max);
        return ans;

    }
}
