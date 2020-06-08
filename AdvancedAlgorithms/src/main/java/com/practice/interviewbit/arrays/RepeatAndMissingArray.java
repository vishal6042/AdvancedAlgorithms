package com.practice.interviewbit.arrays;

/**
 * https://www.interviewbit.com/problems/repeat-and-missing-number-array/
 * <p>
 * You are given a read only array of n integers from 1 to n.
 * <p>
 * Each integer appears exactly once except A which appears twice and B which is missing.
 * <p>
 * Return A and B.
 * <p>
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Note that in your output A should precede B.
 * <p>
 * Example:
 * <p>
 * Input:[3 1 2 5 3]
 * <p>
 * Output:[3, 4]
 * <p>
 * A = 3, B = 4
 */
public class RepeatAndMissingArray {

    public static void main(String[] args) {
        int arr[] = new RepeatAndMissingArray().repeatedNumber(new int[]{1, 2, 3, 2, 4});
        System.out.println(arr[0] + " " + arr[1]);
    }

    public int[] repeatedNumber(final int[] A) {
        int ans[] = new int[2];
        for (int i = 0; i < A.length; i++) {
            int index = Math.abs(A[i]) - 1;
            if (A[index] < 0) {
                ans[0] = index + 1;
            } else {
                A[index] = -1 * A[index];
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                ans[1] = i + 1;
                break;
            }
        }

        return ans;
    }
}
