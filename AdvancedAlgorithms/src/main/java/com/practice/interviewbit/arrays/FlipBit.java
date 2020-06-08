package com.practice.interviewbit.arrays;

public class FlipBit {
    public static void main(String[] args) {
        int arr[] = new FlipBit().flip("01001");
        if (arr.length == 2) {
            System.out.println(arr[0] + " " + arr[1]);
        }
    }

    public int[] flip(String A) {
        int max = 0;
        int maxHere = 0;
        int[] ans = new int[2];
        int start = 0;
        boolean isDone = false;
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            maxHere += (c == '0') ? 1 : -1;
            if (maxHere < 0) {
                maxHere = 0;
                start = (c == '0') ? i : i + 1;
            } else {
                if (max < maxHere) {
                    max = maxHere;
                    ans[0] = start;
                    ans[1] = i;
                    isDone = true;
                }
            }
        }
        if (!isDone) {
            return new int[0];
        }
        return ans;
    }
}
