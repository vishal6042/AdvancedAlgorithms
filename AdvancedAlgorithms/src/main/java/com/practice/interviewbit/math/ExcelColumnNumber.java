package com.practice.interviewbit.math;

/**
 * https://www.interviewbit.com/problems/excel-column-number/
 * <p>
 * Given a column title as appears in an Excel sheet, return its corresponding column number.
 * <p>
 * Example:
 * <p>
 * A -> 1
 * <p>
 * B -> 2
 * <p>
 * C -> 3
 * <p>
 * ...
 * <p>
 * Z -> 26
 * <p>
 * AA -> 27
 * <p>
 * AB -> 28
 */
public class ExcelColumnNumber {

    public static void main(String[] args) {
        System.out.println(new ExcelColumnNumber().titleToNumber("Z"));
    }

    public int titleToNumber(String A) {
        if (A == null || A.isEmpty()) {
            return 0;
        }
        int val = 0;
        for (int i = A.length() - 1; i >= 0; i--) {
            val += (A.charAt(i) - 64) * Math.pow(26, A.length() - (i + 1));
        }
        return val;

    }
}
