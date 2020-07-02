package com.practice.interviewbit.binarysearch;

/**
 * https://www.interviewbit.com/problems/implement-power-function/
 * <p>
 * Implement pow(x, n) % d.
 * <p>
 * In other words, given x, n and d,
 * <p>
 * find (xn % d)
 * <p>
 * Note that remainders on division cannot be negative.
 * In other words, make sure the answer you return is non negative.
 * <p>
 * Input : x = 2, n = 3, d = 3
 * Output : 2
 * <p>
 * 2^3 % 3 = 8 % 3 = 2.
 */
public class ImplementPowerFunctions {

    public static void main(String[] args) {
        ImplementPowerFunctions power = new ImplementPowerFunctions();
        System.out.println(power.pow(-2, 3, 3));
    }

    public int pow(int x, int n, int d) {

        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (x < 0) {
            x = d + x;
        }
        if (n == 1) {
            return (int) (x % d);
        }

        long ans = power(x, n, d);
        return (int) (ans % d);
    }

    private long power(int x, int n, int d) {
        if (n == 0) {
            return 1;
        }
        long temp = power(x, n / 2, d);
        if (n % 2 == 0) {
            return ((temp % d) * (temp % d)) % d;
        } else {
            return (((x % d) * (temp % d)) % d * (temp % d)) % d;
        }
    }
}
