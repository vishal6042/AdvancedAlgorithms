package com.practice.interviewbit.strings;

public class RomanToInteger {

    public static void main(String[] args) {
        RomanToInteger rti = new RomanToInteger();
        System.out.println(rti.romanToInt("XXXIV"));
        System.out.println(rti.romanToInt("LXX"));
    }

    public int romanToInt(String A) {

        int ans = 0;
        for (int i = 0; i < A.length(); i++) {
            ans += getVal(A.charAt(i));
            if (i > 0 && getVal(A.charAt(i)) > getVal(A.charAt(i - 1))) {
                ans -= 2 * getVal(A.charAt(i - 1));
            }
        }
        return ans;
    }

    private int getVal(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
