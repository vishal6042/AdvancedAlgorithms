package com.practice.interviewbit.dynamic;

public class WildCardMatching {
    public int isMatch(final String str, final String pattern) {
        int n1 = str.length();
        int n2 = pattern.length();

        int index = 0;
        boolean isFirst = true;
        char[] pat = pattern.toCharArray();
        for (int i = 0; i < n2; i++) {
            if (pattern.charAt(i) == '*') {
                if (isFirst) {
                    pat[index++] = pattern.charAt(i);
                    isFirst = false;
                }
            } else {
                pat[index++] = pattern.charAt(i);
                isFirst = true;
            }
        }
        String newPattern = new String(pat, 0, index);
      //  System.out.println(newPattern);

        boolean[][] dp = new boolean[n1 + 1][newPattern.length() + 1];
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= newPattern.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    if (newPattern.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 1];
                    }
                } else if (j == 0) {
                    if (str.charAt(i - 1) == '*') {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    if (newPattern.charAt(j - 1) == '?' || (str.charAt(i - 1) == newPattern.charAt(j - 1))) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (newPattern.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    } else {
                        dp[i][j] = false;
                    }

                }
            }
        }
        return dp[n1][newPattern.length()] ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(new WildCardMatching().isMatch(
                "xbylmz", "x?y*********z"
        ));
    }

}
