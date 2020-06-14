package com.practice.interviewbit.arrays;

/**
 * https://www.interviewbit.com/problems/maxspprod/
 * <p>
 * You are given an array A containing N integers. The special product of each ith integer in this array is defined as the product of the following:<ul>
 * <p>
 * LeftSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (i>j). If multiple A[j]’s are present in multiple positions, the LeftSpecialValue is the maximum value of j.
 * <p>
 * RightSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (j>i). If multiple A[j]s are present in multiple positions, the RightSpecialValue is the minimum value of j.
 * <p>
 * Write a program to find the maximum special product of any integer in the array.
 * <p>
 * Input: You will receive array of integers as argument to function.
 * <p>
 * Return: Maximum special product of any integer in the array modulo 1000000007.
 * <p>
 * Note: If j does not exist, the LeftSpecialValue and RightSpecialValue are considered to be 0.
 * <p>
 * Constraints 1 <= N <= 10^5 1 <= A[i] <= 10^9
 */
public class MaxProduct {

    public static void main(String[] args) {
        int[] a = {7, 5, 7, 9, 8, 7};
        System.out.println(new MaxProduct().maxSpecialProduct(a));
    }

    private static final long MOD = 1000000007L;

    public int maxSpecialProduct(int[] A) {
        if (A == null || A.length < 2) {
            return 0;
        }

        int n = A.length;
        long ans = 0;
        long prod;
        long maxL, maxR;

        for (int i = n - 2; i >= 0; i--) {
            maxL = maxR = 0;
            for (int j = i + 1; j < n; j++) {
                if (A[j] > A[i]) {
                    maxR = j;
                    break;
                }
            }

            for (int j = i - 1; j >= 0; j--) {
                if (A[j] > A[i]) {
                    maxL = j;
                    break;
                }
            }
            prod = maxL * maxR;
            if (prod > ans) {
                ans = prod;
            }
        }
        return (int) (ans % MOD);

    }
}
