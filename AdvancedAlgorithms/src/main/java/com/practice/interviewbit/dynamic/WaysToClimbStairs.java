package com.practice.interviewbit.dynamic;

public class WaysToClimbStairs {
    public int climbStairs(int A) {
        if (A == 0) {
            return 1;
        }
        int[] dp = new int[A + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= A; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[A];
    }

    public static void main(String[] args) {
        System.out.println(new WaysToClimbStairs().climbStairs(36));
    }
}
