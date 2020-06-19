package com.practice.interviewbit.strings;

public class ZigZagString {
    public static void main(String[] args) {
        ZigZagString zigzag = new ZigZagString();
        System.out.println(zigzag.convert("ABCDEFGHIJKLMNOPQRS", 6));
    }

    private int gap(int row, int N, int cnt) {
        if (row == 0 || row == N - 1) return 2 * (N - 1);

        if (cnt % 2 == 0)
            return 2 * (N - row - 1);
        else
            return 2 * row;
    }


    public String convert(String str, int N) {

        if (N <= 1 || str.length() <= 1) {
            return str;
        }
        StringBuilder ans = new StringBuilder();
        for (int row = 0; row < N; row++) {
            int loc = row;
            int cnt = 0;

            while (loc <= str.length() - 1) {
                ans.append(str.charAt(loc));
                loc += gap(row, N, cnt);
                cnt++;
            }
        }
        return ans.toString();
    }
}
