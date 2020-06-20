package com.practice.interviewbit.twopointer;

public class ContainerMostWater {
    public int maxArea(int[] A) {
        if (A == null || A.length <= 1) {
            return 0;
        }
        int i = 0;
        int j = A.length - 1;
        int max = Integer.MIN_VALUE;

        while (i < j) {
            int area = (j - i) * Math.min(A[i], A[j]);
            if (area > max) {
                max = area;
            }
            if (A[i] <= A[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int a[] = {1, 5, 4, 3};
        int b[] = {3, 1, 2, 4, 5};
        System.out.println(
                new ContainerMostWater().maxArea(a)
        );
        System.out.println(
                new ContainerMostWater().maxArea(b)
        );
    }
}
