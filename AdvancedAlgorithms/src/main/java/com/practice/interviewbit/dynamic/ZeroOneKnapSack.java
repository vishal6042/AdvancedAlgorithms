package com.practice.interviewbit.dynamic;

public class ZeroOneKnapSack {
    public int solve(int[] value, int[] weight, int capacity) {
        int[][] dp = new int[value.length + 1][capacity + 1];
        for (int i = 0; i <= value.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (j - weight[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[value.length][capacity];
    }

    public static void main(String[] args) {
        System.out.println(new ZeroOneKnapSack().solve(
                new int[]{160, 100, 10},
                new int[]{10, 20, 30},
                50
        ));
    }
}
