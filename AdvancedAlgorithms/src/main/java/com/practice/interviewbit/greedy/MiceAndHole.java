package com.practice.interviewbit.greedy;

import java.util.Arrays;

public class MiceAndHole {
    public int mice(int[] A, int[] B) {
        if (A.length != B.length) {
            return -1;
        }

        Arrays.sort(A);
        Arrays.sort(B);
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int diff = Math.abs(A[i] - B[i]);
            maxDiff = Math.max(maxDiff, diff);
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        System.out.println(new MiceAndHole().mice(
                new int[]{2, 4, -4},
                new int[]{4, 5, -3}
        ));
    }
}
