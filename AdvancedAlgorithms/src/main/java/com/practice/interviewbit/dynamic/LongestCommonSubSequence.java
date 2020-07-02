package com.practice.interviewbit.dynamic;

public class LongestCommonSubSequence {
    public int solve(String a, String b) {
        int n1 = a.length();
        int n2 = b.length();

        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n2; i++) {
            for (int j = 1; j <= n1; j++) {
                if (b.charAt(i - 1) == a.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubSequence().solve("abbcdgf", "bbadcgf"));
    }
}
