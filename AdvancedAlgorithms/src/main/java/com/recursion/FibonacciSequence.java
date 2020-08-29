package com.recursion;


import java.util.Arrays;

public class FibonacciSequence {
    static int dp[] = new int[1000];

    public static void main(String[] args) {

        System.out.println("Printing FIBO using LOOP");
        Arrays.fill(dp, -1);
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 1; i <= 10; i++) {
            System.out.print(fiboRecur2(i) + " ");
        }
    }

    // DYnamic Programming using Memoization
    private static int fiboRecur2(int i) {
        if (dp[i] != -1) {
            return dp[i];
        }
        int ans = fibo(i - 1) + fibo(i - 2);
        dp[i] = ans;
        return ans;
    }

    // Dynamic programming using Top Down Approach
    private static int fiboRecur(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }

        return fibo(i - 1) + fibo(i - 2);
    }

    private static int fibo(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        int first = 0;
        int second = 1;

        int sum = 0;

        for (int j = 3; j <= i; j++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;

    }
}
