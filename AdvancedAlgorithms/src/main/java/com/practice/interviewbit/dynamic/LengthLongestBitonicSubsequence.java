package com.practice.interviewbit.dynamic;

public class LengthLongestBitonicSubsequence {
    public int longestSubsequenceLength(final int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int dp[][] = new int[A.length][2];
        for (int i = 0; i < A.length; i++) {
            dp[i][0] = dp[i][1] = 1;
        }

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {

                if (A[i] > A[j] && dp[i][0] < dp[j][0] + 1) {
                    dp[i][0] = dp[j][0] + 1;
                }
            }
        }
        for (int i = A.length - 2; i >= 0; i--) {
            for (int j = A.length - 1; j > i; j--) {

                if (A[i] > A[j] && dp[i][1] < dp[j][1] + 1) {
                    dp[i][1] = dp[j][1] + 1;
                }
            }
        }
        int ans = dp[0][0] + dp[0][1] - 1;
        for (int i = 0; i < A.length; i++) {
            ans = Math.max(ans, (dp[i][0] + dp[i][1] - 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LengthLongestBitonicSubsequence().longestSubsequenceLength(
                new int[]{1, 3, 5, 6, 4, 8, 4, 3, 2, 1}
        ));
    }

}
