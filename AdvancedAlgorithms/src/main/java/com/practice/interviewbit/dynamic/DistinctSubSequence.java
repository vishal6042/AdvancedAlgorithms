package com.practice.interviewbit.dynamic;

public class DistinctSubSequence {
    public int numDistinct(String a, String b) {
        int n1 = a.length();
        int n2 = b.length();
        if (n1 == 0 || n2 == 0) {
            return 0;
        }
        int[][] dp = new int[n2 + 1][n1 + 1];

        for (int i = 0; i <= n1; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= n2; i++) {
            for (int j = 1; j <= n1; j++) {
                if (a.charAt(j - 1) == b.charAt(i - 1)) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }

            }
        }
        return dp[n2][n1];

    }

    public static void main(String[] args) {
        System.out.println(new DistinctSubSequence().numDistinct("rabbbit", "rabbit"));
    }
}
