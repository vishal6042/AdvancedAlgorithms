package com.practice.interviewbit.arrays;

import java.util.Arrays;

/**
 * https://www.interviewbit.com/problems/largest-number/
 * <p>
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * <p>
 * For example:
 * <p>
 * Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * <p>
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
    public static void main(String[] args) {
        //  System.out.println(new LargestNumber().largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(new LargestNumber().largestNumber(new int[]{0, 0, 0, 0, 0}));

    }

    public String largestNumber(final int[] A) {
        String arr[] = new String[A.length];
        for (int i = 0; i < A.length; i++) {
            arr[i] = String.valueOf(A[i]);
        }

        Arrays.sort(arr, (o1, o2) -> {
            String o1o2 = o1 + o2;
            String o2o1 = o2 + o1;
            if (o1o2.compareTo(o2o1) > 0) {
                return -1;
            } else {
                return 1;
            }
        });
        StringBuilder ans = new StringBuilder();
        boolean isAllZero = false;
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals("0")) {
                isAllZero = true;
            }
            ans.append(arr[i]);
        }
        if (!isAllZero) {
            return "0";
        }

        return ans.toString();
    }
}
