package com.practice.interviewbit.dynamic;

public class WaysToDecode {
    public static final int MOD = 1000000007;

    public int numDecodings(String A) {
        if (A.charAt(0) == '0') return 0;
        int[] dp = new int[A.length() + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= A.length(); i++) {

            dp[i] = 0;
            if (A.charAt(i - 1) > '0') {
                dp[i] = dp[i - 1];
            }

            if (A.charAt(i - 2) == '1' || (A.charAt(i - 2) == '2' && A.charAt(i - 1) < '7')) {
                dp[i] = ((dp[i] % MOD) + (dp[i - 2] % MOD)) % MOD;
            }
        }
        return dp[A.length()];
    }

    public static void main(String[] args) {
        System.out.println(new WaysToDecode().numDecodings("12121"));
    }
}
