package com.practice.interviewbit.twopointer;

public class DifferenceK {

    public static void main(String[] args) {
        System.out.println(
                new DifferenceK().diffPossible(
                        new int[]{1, 2, 3},
                        83
                )
        );
    }

    public int diffPossible(int[] A, int B) {
        int i = A.length - 1;
        int j = A.length - 2;

        while (i >= 0 && j >= 0) {
            int diff = Math.abs(A[i] - A[j]);
            if (diff == B && i!= j) {
                return 1;
            } else if (diff > B) {
                i--;
            } else {
                j--;
            }

        }
        return 0;
    }
}
