package com.practice.interviewbit.hashing;

import java.util.HashMap;
import java.util.Map;

public class Fractions {
    public String fractionToDecimal(int a, int b) {
        if (a == 0) {
            return "0";
        }

        int sign = (a < 0) ^ (b < 0) ? -1 : 1;  // use xor for both negative

        long A = Math.abs((long) a);
        long B = Math.abs((long) b);

        long real = A / B;
        StringBuilder result = new StringBuilder();
        if (sign == -1) {
            result.append("-");
        }
        result.append(String.valueOf(real));
        if (A % B == 0) {
            return result.toString();
        }

        result.append(".");
        long remainder = A % B;
        Map<Long, Integer> map = new HashMap<>();

        int index = 0;
        boolean repeating = false;
        while (remainder > 0 && !repeating) {
            if (map.containsKey(remainder)) {
                index = map.get(remainder);
                repeating = true;
                break;
            } else {
                map.put(remainder, result.length());
            }
            remainder = remainder * 10;
            long temp = remainder / B;
            result.append(String.valueOf(temp));
            remainder %= B;
        }
        if (repeating) {
            result = new StringBuilder(result.substring(0, index) + "(" + result.substring(index) + ")");
        }
        return result.toString();

    }

    public static void main(String[] args) {
        System.out.println(new Fractions().fractionToDecimal(16, 7));
    }
}
