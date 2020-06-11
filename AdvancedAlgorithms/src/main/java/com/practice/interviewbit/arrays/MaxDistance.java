package com.practice.interviewbit.arrays;

/**
 * https://www.interviewbit.com/problems/max-distance/
 * <p>
 * Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
 * <p>
 * If there is no solution possible, return -1.
 * <p>
 * Example :
 * <p>
 * A : [3 5 4 2]
 * <p>
 * Output : 2
 * for the pair (3, 4)
 */
public class MaxDistance {

    public static void main(String[] args) {
        System.out.println(new MaxDistance().maximumGap(new int[]{3, 5, 4, 2}));
    }

    public int maximumGap(final int[] A) {
        int length = A.length;
        if (length == 0) {
            return -1;
        }
        int left[] = new int[length];
        int right[] = new int[length];

        left[0] = A[0];
        for (int i = 1; i < length; i++) {
            left[i] = Math.min(left[i - 1], A[i]);
        }
        right[length - 1] = A[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], A[i]);
        }

        int i = 0, j = 0, maxDiff = -1;
        while (i < length && j < length) {
            if (left[i] <= right[j]) {
                maxDiff = Math.max(maxDiff, (j - i));
                j++;
            } else {
                i++;
            }
        }

        return maxDiff;

    }
}
