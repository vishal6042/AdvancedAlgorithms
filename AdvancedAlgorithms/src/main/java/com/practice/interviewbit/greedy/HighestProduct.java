package com.practice.interviewbit.greedy;

public class HighestProduct {
    public int maxp3(int[] A) {
        if (A.length <= 2) {
            return -1;
        }
        if (A.length == 3) {
            return A[0] * A[1] * A[2];
        }
        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        int tMax = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;

        for (int value : A) {
            if (value > max) {
                tMax = smax;
                smax = max;
                max = value;
            } else if (value > smax) {
                tMax = smax;
                smax = value;
            } else if (value > tMax) {
                tMax = value;
            }

            if (value < min) {
                smin = min;
                min = value;
            } else if (value < smin) {
                smin = value;
            }

        }

        return Math.max(max * smax * tMax, max * min * smin);
    }

    public static void main(String[] args) {
        System.out.println(
                new HighestProduct().maxp3(
                        new int[]{0, -1, -100000, 3, 100, 70, 50}
                )
        );
    }
}
