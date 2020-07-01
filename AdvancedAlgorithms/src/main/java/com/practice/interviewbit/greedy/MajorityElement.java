package com.practice.interviewbit.greedy;

public class MajorityElement {
    public int majorityElement(final int[] A) {
        int majorityIndex = 0;
        int count = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[majorityIndex]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                majorityIndex = i;
                count = 1;
            }
        }
        return A[majorityIndex];
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{1, 2, 6, 2, 4, 2, 2, 7, 2, 4, 2, 2}));
    }
}
