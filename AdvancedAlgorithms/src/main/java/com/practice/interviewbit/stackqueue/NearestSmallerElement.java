package com.practice.interviewbit.stackqueue;

import java.util.Stack;

public class NearestSmallerElement {

    public int[] prevSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {

            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] ans = new NearestSmallerElement().prevSmaller(new int[]{4, 5, 2, 10, 6, 8, 3});
        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}
