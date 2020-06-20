package com.practice.interviewbit.twopointer;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxContinuousSeries {

    public static void main(String[] args) {
        System.out.println(
                new MaxContinuousSeries().maxone(
                        new ArrayList<>(Arrays.asList(1, 1, 0, 1, 1, 0, 0, 1, 1, 1)),
                        1
                )
        );
    }

    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = 0;

        int windowSize = 0;
        int zeroCount = 0;

        while (right < A.size()) {
            if (zeroCount <= B) {
                if (A.get(right) == 0) {
                    zeroCount++;
                }
                right++;
            }
            if (zeroCount > B) {
                if (A.get(left) == 0) {
                    zeroCount--;
                }
                left++;
            }
            if ((right - left > windowSize) && (zeroCount <= B)) {
                windowSize = right - left;
                if (!ans.isEmpty()) {
                    ans.clear();
                }
                for (int i = left; i < right; i++) {
                    ans.add(i);
                }
            }
        }
        return ans;
    }
}
