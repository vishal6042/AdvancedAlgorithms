package com.practice.interviewbit.math;

/**
 * https://www.interviewbit.com/problems/power-of-two-integers/
 * <p>
 * Given a positive integer which fits in a 32 bit signed integer, find if it can be expressed as A^P where P > 1 and A > 0. A and P both should be integers.
 * <p>
 * Example
 * <p>
 * Input : 4
 * Output : True
 * as 2^2 = 4.
 */
public class PowerOfTwoInteger {

    public static void main(String[] args) {
        PowerOfTwoInteger power = new PowerOfTwoInteger();
        System.out.println(power.isPower(536870912));
    }

    public int isPower(int A) {

        if (A <= 1) {
            return 1;
        }
        double p;
        for (int i = 2; i <= Math.sqrt(A); i++) {
            p = Math.log10(A) / Math.log10(i);
            if ((Math.ceil(p) == Math.floor(p)) && p > 1) {
                return 1;
            }
        }
        return 0;
    }
}
