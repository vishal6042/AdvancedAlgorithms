package com.practice.interviewbit.twopointer;

public class MinimizeTheAbsoluteDifference {
    public static void main(String[] args) {
        System.out.println(new MinimizeTheAbsoluteDifference().solve(
                new int[]{1, 4, 15, 8, 10},
                new int[]{6, 9, 15},
                new int[]{2, 3, 6, 6}
        ));
    }

    public int solve(int[] A, int[] B, int[] C) {
        int i = 0;
        int j = 0;
        int k = 0;

        int minAns = Integer.MAX_VALUE;
        while (i < A.length && j < B.length && k < C.length) {

            int min = Math.min(A[i], Math.min(B[j], C[k]));
            int max = Math.max(A[i], Math.max(B[j], C[k]));
            minAns = Math.min(minAns, Math.abs(min - max));
            if (min == A[i]) {
                i++;
            } else if (min == B[j]) {
                j++;
            } else {
                k++;
            }
        }
        return minAns;
    }
}
