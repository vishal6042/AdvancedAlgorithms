package com.practice.interviewbit.dynamic;

public class IntersectingChordsInCircle {
    private static final int MOD = 1000000007;

    public int chordCnt(int A) {
        if (A == 1) {
            return 1;
        }
        long[] dp = new long[A + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= A; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = ((dp[i]) + (dp[j] * dp[i - 1 - j]) % MOD) % MOD;
            }
        }
        return (int) dp[A];
    }

    public int chordCnt2(int A) {
        if (A == 1) {
            return 1;
        }
        int n = A * 2;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[2] = 1;

        for (int i = 4; i <= n; i += 2) {
            for (int j = 0; j < i - 1; j += 2) {
                dp[i] = ((dp[i] % MOD) + ((dp[j] % MOD) * (dp[i - 2 - j] % MOD))) % MOD;
            }
        }
        return (int) dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new IntersectingChordsInCircle().chordCnt(22));
    }

}
