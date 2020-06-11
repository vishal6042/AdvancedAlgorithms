package com.practice.interviewbit.arrays;

public class MaximumUnsortedSubArray {

    public static void main(String[] args) {
        int arr[] = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
        int arr1[] = {1, 1, 2, 8, 8, 3, 8, 3, 8, 3, 8, 10, 13, 14, 14, 15, 16};
        int ans[] = new MaximumUnsortedSubArray().subUnsort(arr1);
        if (ans.length == 1) {
            System.out.println(ans[0]);
        } else {
            System.out.println(ans[0] + " " + ans[1]);
        }
    }

    public int[] subUnsort(int[] A) {
        if (A == null) {
            return null;
        }
        if (A.length == 1) {
            return new int[]{-1};
        }

        int firstAbruptIndexFromLeft = -1;
        int lastAbruptIndexFromRight = -1;

        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                firstAbruptIndexFromLeft = i - 1;
                break;
            }
        }
        if (firstAbruptIndexFromLeft == -1) {
            return new int[]{-1};
        }
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                lastAbruptIndexFromRight = i + 1;
                break;
            }
        }
        int minInAbruptSubArray = Integer.MAX_VALUE;
        int maxInAbruptSubArray = Integer.MIN_VALUE;
        for (int i = firstAbruptIndexFromLeft; i <= lastAbruptIndexFromRight; i++) {
            if (A[i] >= maxInAbruptSubArray) {
                maxInAbruptSubArray = A[i];
            }
            if (A[i] <= minInAbruptSubArray) {
                minInAbruptSubArray = A[i];
            }
        }
        int ans[] = new int[2];
        ans[0] = firstAbruptIndexFromLeft;
        ans[1] = lastAbruptIndexFromRight;
        for (int i = 0; i < firstAbruptIndexFromLeft; i++) {
            if (A[i] > minInAbruptSubArray) {
                ans[0] = i;
                break;
            }
        }
        for (int i = A.length - 1; i > lastAbruptIndexFromRight; i--) {
            if (A[i] < maxInAbruptSubArray) {
                ans[1] = i;
                break;
            }
        }
        return ans;
    }
}
