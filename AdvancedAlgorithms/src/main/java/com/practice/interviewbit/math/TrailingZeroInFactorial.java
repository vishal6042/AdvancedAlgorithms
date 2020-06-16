package com.practice.interviewbit.math;

public class TrailingZeroInFactorial {
    public static void main(String[] args) {
        TrailingZeroInFactorial tZeros = new TrailingZeroInFactorial();
        System.out.println(tZeros.trailingZeroes(1000));
        System.out.println(tZeros.trailingZeroes(23));
        System.out.println(tZeros.trailingZeroes(101));
        System.out.println(tZeros.trailingZeroes(4617));
    }

    public int trailingZeroes(int A) {
        if (A == 0) {
            return 0;
        }
        int ans = 0;
        while (A > 0) {
            ans += (A / 5);
            A /= 5;
        }
        return ans;
    }
}
