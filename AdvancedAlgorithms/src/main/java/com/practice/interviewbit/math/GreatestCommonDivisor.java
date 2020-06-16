package com.practice.interviewbit.math;

/**
 * https://www.interviewbit.com/problems/greatest-common-divisor/
 * <p>
 * Given 2 non negative integers m and n, find gcd(m, n)
 * <p>
 * GCD of 2 integers m and n is defined as the greatest integer g such that g is a divisor of both m and n.
 * Both m and n fit in a 32 bit signed integer.
 */
public class GreatestCommonDivisor {
    public static void main(String[] args) {
        GreatestCommonDivisor gcd = new GreatestCommonDivisor();
        System.out.println(gcd.gcd(6, 9));
    }

    public int gcd(int A, int B) {
        if (B > A) {
            int t = A;
            A = B;
            B = t;
        }
        if (A == 0) {
            return B;
        }
        if (B == 0) {
            return A;
        }
        int rem = A % B;
        if (rem != 0) {
            return gcd(B, rem);
        }
        return B;
    }
}
