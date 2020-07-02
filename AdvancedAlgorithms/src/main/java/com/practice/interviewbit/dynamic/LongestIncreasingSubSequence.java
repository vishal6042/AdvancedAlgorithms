package com.practice.interviewbit.dynamic;

import java.util.Arrays;

public class LongestIncreasingSubSequence {
    public int lis(final int[] A) {

        if (A.length == 1) {
            return 1;
        }
        int[] dp = new int[A.length + 1];
        Arrays.fill(dp, 1);

        int ans = 0;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestIncreasingSubSequence sequence = new LongestIncreasingSubSequence();
        System.out.println(sequence.lis(new int[]{1, 2, 1, 5}));
        System.out.println(sequence.lis(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}));
    }
}
