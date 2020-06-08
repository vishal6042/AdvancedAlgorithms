package com.practice.interviewbit.arrays;

public class RepeatAndMissingArray {

    public static void main(String[] args) {
        int arr[] = new RepeatAndMissingArray().repeatedNumber(new int[]{1, 2, 3, 2, 4});
        System.out.println(arr[0] + " " + arr[1]);
    }

    public int[] repeatedNumber(final int[] A) {
        int ans[] = new int[2];
        for (int i = 0; i < A.length; i++) {
            int index = Math.abs(A[i]) - 1;
            if (A[index] < 0) {
                ans[0] = index + 1;
            } else {
                A[index] = -1 * A[index];
            }
        }
        for (int i = 0; i < A.length ; i++) {
            if(A[i] > 0){
                ans[1] = i + 1;
                break;
            }
        }

        return ans;
    }
}
