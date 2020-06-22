package com.practice.interviewbit.backtracking;

import java.util.ArrayList;

public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> ans = new ArrayList<>();

        ArrayList<String> arr = new ArrayList<>();
        arr.add("0");
        arr.add("1");

        for (int i = 2; i < (1 << n); i = i << 1) {
            for (int j = i - 1; j >= 0; j--) {
                arr.add(arr.get(j));
            }
            for (int j = 0; j < i; j++) {
                arr.set(j, "0" + arr.get(j));
            }
            for (int j = i; j < 2 * i; j++) {
                arr.set(j, "1" + arr.get(j));
            }
        }
        for (String val : arr) {
            ans.add(Integer.parseInt(val, 2));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new GrayCode().grayCode(3));
    }
}
