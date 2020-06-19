package com.practice.interviewbit.strings;

import java.math.BigInteger;

public class PowerOfTwo {

    public static void main(String[] args) {
        PowerOfTwo pot = new PowerOfTwo();
        System.out.println(pot.power("5070602400912917605986812821504"));
    }

    public int power1(String A) {
        StringBuilder sb = new StringBuilder(A);
        A = sb.reverse().toString();
        String B = "1";

        while (B.length() <= A.length()) {
            String temp = "";
            int carry = 0;

            for (int i = 0; i < B.length(); i++) {
                int digit = ((B.charAt(i) - '0') * 2 + carry) % 10;
                carry = ((B.charAt(i) - '0') * 2 + carry) / 10;
                temp += String.valueOf(digit);

            }
            if (carry != 0) {
                temp += String.valueOf(carry);
            }
            B = temp;
            if (B.equals(A)) {
                return 1;
            }
        }
        return 0;

    }
    public int power(String A) {
        BigInteger bi = new BigInteger(A);
        if(bi.equals(BigInteger.ONE)) return 0;
        if(bi.equals(BigInteger.ZERO)) return 0;

        while(bi.remainder(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            bi = bi.divide(BigInteger.valueOf(2));
        }

        if(bi.equals(BigInteger.ONE)) return 1;
        return 0;
    }

    public int power2(String A) {
        double val = 0;
        for (int i = 0; i < A.length(); i++) {
            val = val * 10 + (A.charAt(i) - '0');
        }
        if (val == 1) {
            return 0;
        }
        double log = Math.log10(val) / Math.log10(2);
        if (Math.ceil(log) == Math.floor(log)){
            return 1;
        }
        return 0;
    }

}
