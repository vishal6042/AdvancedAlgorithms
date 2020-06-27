package com.practice.interviewbit.heap;

import java.util.Arrays;

public class DistinctMaxHeaps {
    public static final int MOD = 1000000007;
    int log2[] = new int[101];
    int dp[] = new int[101];

    public int solve(int n) {
        if (n <= 1) {
            return 1;
        }
        preprocess(n);
        int ans = solveUtil(n);
        return ans % MOD;

    }

    private int solveUtil(int n) {
        if (n <= 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int left = getLeft(n);
        int ans = ((binomialCoeff(n - 1, left) % MOD)
                * (solveUtil(left) % MOD) *
                (solveUtil(n - 1 - left) % MOD)) % MOD;
        dp[n] = ans;
        return ans;
    }

    private void preprocess(int n) {
        Arrays.fill(dp, -1);
        int currPower2 = 1;
        int currLog2 = -1;
        for (int i = 1; i <= n; i++) {
            if (currPower2 == i) {
                currLog2++;
                currPower2 *= 2;
            }
            log2[i] = currLog2;
        }
    }

    public int getLeft(int n) {
        if (n == 1) {
            return 0;
        }

        int h = log2[n];
        int numh = (1 << h); //(2 ^ h)
        int last = n - ((1 << h) - 1);

        if (last >= (numh / 2)) {
            return (1 << h) - 1; // (2^h) - 1
        } else {
            return (1 << h) - 1 - ((numh / 2) - last);
        }
    }


    private int binomialCoeff(int n, int k) {
        int[][] C = new int[n + 1][k + 1];
        int i, j;

        for (i = 0; i <= n; i++) {
            for (j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i)
                    C[i][j] = 1;
                else
                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }

        return C[n][k];
    }

    public static void main(String[] args) {
        System.out.println(new DistinctMaxHeaps().solve(20));
    }
}
