package com.practice.interviewbit.greedy;

import java.util.Arrays;

public class DistributeCandy {
    public int candy(int[] A) {
        int ans = 0;
        int[] candies = new int[A.length];
        Arrays.fill(candies, 1);

        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1] && candies[i] <= candies[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }
        for (int i = 0; i < A.length; i++) {
            ans += candies[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new DistributeCandy().candy(new int[]{1, 5, 3, 2}));
    }
}
