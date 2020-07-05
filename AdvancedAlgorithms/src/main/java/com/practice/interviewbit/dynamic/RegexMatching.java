package com.practice.interviewbit.dynamic;

public class RegexMatching {
    public int isMatch(final String str, final String patt) {
        int n1 = str.length();
        int n2 = patt.length();

        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n2; i++) {
            if (patt.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (patt.charAt(j - 1) == '.' || (patt.charAt(j - 1) == str.charAt(i - 1))) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (patt.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (patt.charAt(j - 2) == '.' || (str.charAt(i - 1) == patt.charAt(j - 2))) {
                        dp[i][j] = dp[i][j] | dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n1][n2] ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(new RegexMatching().isMatch("aab", "c*a*b"));
    }
}
