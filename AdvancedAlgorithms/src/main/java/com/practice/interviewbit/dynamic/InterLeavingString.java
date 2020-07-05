package com.practice.interviewbit.dynamic;

public class InterLeavingString {
    public int isInterleave(String a, String b, String c) {
        int n1 = a.length();
        int n2 = b.length();
        int n3 = c.length();

        if (n3 != n1 + n2) {
            return 0;
        }
        int[][] dp = new int[n1 + 1][n2 + 1];
        dp[0][0] = 1;
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                int len = i + j - 1;
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    if (c.charAt(len) == b.charAt(j - 1)) {
                        dp[i][j] = dp[i][j - 1];
                    }
                } else if (j == 0) {
                    if (c.charAt(len) == a.charAt(i - 1)) {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    int val = 0;
                    int val1 = 0;
                    if (c.charAt(len) == a.charAt(i - 1)) {
                        val = dp[i - 1][j];
                    }
                    if (c.charAt(len) == b.charAt(j - 1)) {
                        val1 = dp[i][j - 1];
                    }
                    dp[i][j] = (val == 1 || val1 == 1) ? 1 : 0;
                }
            }
        }
//        for (int i = 0; i <= n1; i++) {
//            for (int j = 0; j <= n2; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        return dp[n1][n2];
    }

    public static void main(String[] args) {
        String str1 = "XXYM";
        String str2 = "XXZT";
        String str3 = "XXXZXYTM";

        System.out.println(new InterLeavingString().isInterleave(str1, str2, str3));
    }
}
