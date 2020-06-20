package com.practice.interviewbit.twopointer;

public class MinimizeMaximumDifferenceThreeSortedArrays {

    public static void main(String[] args) {
        System.out.println(
                new MinimizeMaximumDifferenceThreeSortedArrays().minimize(
                        new int[]{5, 8, 10, 14},
                        new int[]{6, 9, 15},
                        new int[]{2, 3, 6, 6}
                )
        );
    }

    public int minimize(final int[] A, final int[] B, final int[] C) {
        int i = 0;
        int j = 0;
        int k = 0;

        int ans = Integer.MAX_VALUE;

        while (i < A.length && j < B.length && k < C.length) {
            int val1 = Math.abs(A[i] - B[j]);
            int val2 = Math.abs(A[i] - C[k]);
            int val3 = Math.abs(B[j] - C[k]);

            int max = Math.max(val1, Math.max(val2, val3));
            if (max < ans) {
                ans = max;
            }
            if (max == val1) {
                if (A[i] >= B[j]) {
                    j++;
                } else {
                    i++;
                }

            } else if (max == val2) {
                if (A[i] >= C[k]) {
                    k++;
                } else {
                    i++;
                }
            } else {
                if (B[j] >= C[k]) {
                    k++;
                } else {
                    j++;
                }
            }
        }
        return ans;
    }

}
