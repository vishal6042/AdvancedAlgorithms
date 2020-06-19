package com.practice.interviewbit.strings;

public class IntegerToRoman {
    public static void main(String[] args) {
        IntegerToRoman itr = new IntegerToRoman();
        System.out.println(itr.intToRoman(985));
        System.out.println(itr.intToRoman(1948));
        System.out.println(itr.intToRoman(999));
    }

    private final int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int A) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < val.length; i++) {
            while (A >= val[i]) {
                A = A - val[i];
                ans.append(romans[i]);
            }
        }
        return ans.toString();
    }


}
