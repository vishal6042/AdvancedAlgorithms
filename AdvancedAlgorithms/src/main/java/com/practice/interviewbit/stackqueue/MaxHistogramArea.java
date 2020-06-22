package com.practice.interviewbit.stackqueue;

import java.util.Stack;

public class MaxHistogramArea {

    public int largestRectangleArea(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return A[0];
        }
        int ans = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; ) {
            if (stack.isEmpty() || A[i] >= A[stack.peek()]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                int area;
                if (stack.isEmpty()) {
                    area = (A[top] * i);
                } else {
                    area = (i - stack.peek() - 1) * A[top];
                }
                if (area > ans) {
                    ans = area;
                }
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area;
            if (stack.isEmpty()) {
                area = (A[top] * A.length);
            } else {
                area = (A.length - stack.peek() - 1) * A[top];
            }
            if (area > ans) {
                ans = area;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                new MaxHistogramArea().largestRectangleArea(
                        new int[]{2, 1, 5, 6, 2, 3}
                )
        );
    }
}
