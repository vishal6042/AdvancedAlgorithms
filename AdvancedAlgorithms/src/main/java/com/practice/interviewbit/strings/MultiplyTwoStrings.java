package com.practice.interviewbit.strings;

import java.util.Arrays;

public class MultiplyTwoStrings {

    public String multiply(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int n1 = a.length;
        int n2 = b.length;

        char[] result = new char[n1 + n2];
        Arrays.fill(result, '0');

        for (int j = n2 - 1; j >= 0; j--) {
            for (int i = n1 - 1; i >= 0; i--) {
                int prod = (a[i] - '0') * (b[j] - '0');
                int temp = result[i + j + 1] - '0' + prod;
                result[i + j + 1] = (char) (temp % 10 + '0');
                result[i + j] = (char) (((result[i + j] - '0') + temp / 10) + '0');
            }
        }
        StringBuilder ans = new StringBuilder();
        boolean seen = false;
        for (char c : result) {
            if (c == '0' && !seen) {
                continue;
            }
            ans.append(c);
            seen = true;
        }
        return ans.length() == 0 ? "0" : ans.toString();

    }

    public String multiply1(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int n1 = a.length;
        int n2 = b.length;

        int result[] = new int[n1 + n2];

        for (int j = n2 - 1; j >= 0; j--) {
            for (int i = n1 - 1; i >= 0; i--) {
                int prod = (a[i] - '0') * (b[j] - '0');
                result[i + j + 1] += prod;
                result[i + j] += result[i + j + 1] / 10;
                result[i + j + 1] %= 10;
            }
        }
        StringBuilder ans = new StringBuilder();
        boolean seen = false;
        for (int c : result) {
            if (c == 0 && !seen) {
                continue;
            }
            ans.append(c);
            seen = true;
        }
        return ans.length() == 0 ? "0" : ans.toString();

    }

    public static void main(String[] args) {
        MultiplyTwoStrings twoStrings = new MultiplyTwoStrings();
        System.out.println(twoStrings.multiply1("12345", "12345"));
    }
}
