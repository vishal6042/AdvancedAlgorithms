package com.practice.interviewbit.math;

public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger pi = new ReverseInteger();
        System.out.println(pi.reverse(12121));
        System.out.println(pi.reverse(1234321));
        System.out.println(pi.reverse(-12343));
        System.out.println(pi.reverse(Integer.MAX_VALUE));
    }

    public int reverse(int A) {
        boolean isNeg = false;
        if (A < 0) {
            A = -1 * A;
            isNeg = true;
        }
        long newNo = 0;
        while (A > 0) {
            int rem = A % 10;
            newNo = newNo * 10 + rem;
            if (newNo > Integer.MAX_VALUE) {
                return 0;
            }
            A = A / 10;
        }
        return (int) (isNeg ? -1 * (newNo) : newNo);
    }
}
