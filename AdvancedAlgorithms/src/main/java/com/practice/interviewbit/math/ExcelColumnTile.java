package com.practice.interviewbit.math;

/**
 * https://www.interviewbit.com/problems/excel-column-title/
 * <p>
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p>
 * For example:
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 */
public class ExcelColumnTile {
    public static void main(String[] args) {
        System.out.println(new ExcelColumnTile().convertToTitle(1379));
    }

    public String convertToTitle(int A) {
        if (A < 1) {
            return "";
        }

        StringBuilder ans = new StringBuilder();
        while (A > 0) {
            int rem = A % 26;
            if (rem == 0) {
                ans.append("Z");
                A = (A / 26) - 1;
            } else {
                ans.append((char) ((rem - 1) + 'A'));
                A = A / 26;
            }
        }
        return ans.reverse().toString();
    }
}
