package com.practice.interviewbit.arrays;

import java.util.PriorityQueue;

/**
 * https://www.interviewbit.com/problems/maximum-consecutive-gap/
 * <p>
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * <p>
 * Try to solve it in linear time/space.
 * <p>
 * Example :
 * <p>
 * Input : [1, 10, 5]
 * Output : 5
 * Return 0 if the array contains less than 2 elements.
 * <p>
 * You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 * You may also assume that the difference will not overflow.
 */
public class MaximumConsecutiveGap {

    public static void main(String[] args) {
        MaximumConsecutiveGap mGap = new MaximumConsecutiveGap();
        System.out.println(mGap.maximumGap(new int[]{1, 10, 8, 5}));
    }

    public int maximumGap(final int[] A) {
        if (A == null) {
            return 0;
        }
        if (A.length < 2) {
            return 0;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < A.length; i++) {
            priorityQueue.add(A[i]);
        }

        int maxDiff = Integer.MIN_VALUE;
        while (priorityQueue.size() > 1) {
            int top = priorityQueue.peek();
            priorityQueue.poll();
            maxDiff = Math.max(maxDiff, Math.abs(top - priorityQueue.peek()));
        }
        return maxDiff;
    }

}
