package com.practice.interviewbit.strings;


public class Atoi {

    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        System.out.println(atoi.atoi("123456"));
        System.out.println(atoi.atoi("   123   456"));
        System.out.println(atoi.atoi("    123456    "));
        System.out.println(atoi.atoi("    C12345C6    "));
        System.out.println(atoi.atoi("12sdsfsf3456"));
        System.out.println(atoi.atoi("sdfs123456"));
        System.out.println(atoi.atoi("5121478262 9874365982346"));
        System.out.println(atoi.atoi("-88297 248252140B12 37239U4622733246I218 9 1303 44 A83793H3G2 1674443R591 4368 7 97"));
    }

    public int atoi(final String A) {
        if (A == null) {
            return 0;
        }
        String s = A.trim();
        boolean isNeg = false;
        if (A.charAt(0) == '-' || A.charAt(0) == '+') {
            isNeg = A.charAt(0) == '-';
            s = s.substring(1);
        }

        int end = 0;
        while (end < s.length()
                && s.charAt(end) != ' '
                && Character.isDigit(s.charAt(end))) {
            end++;
        }
        long curr = 0;
        long mul = 1;
        boolean isBound = false;
        while (--end >= 0) {
            curr += mul * (s.charAt(end) - '0');
            mul *= 10;
            if (curr > Integer.MAX_VALUE) {
                isBound = true;
                break;
            }
        }

        if (isNeg) {
            return isBound ? Integer.MIN_VALUE : (int) (-1 * curr);
        } else {
            return isBound ? Integer.MAX_VALUE : (int) curr;
        }
    }
}
