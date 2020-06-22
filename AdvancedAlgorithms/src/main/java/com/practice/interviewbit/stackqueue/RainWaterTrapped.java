package com.practice.interviewbit.stackqueue;

import java.util.Stack;

public class RainWaterTrapped {
    public static void main(String[] args) {
        System.out.println(
                new RainWaterTrapped().trapUsingStack(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})
        );
    }

    public int trap(final int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        left[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }
        right[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans += (Math.min(right[i], left[i]) - arr[i]);
        }
        return ans;
    }

    public int trapUsingStack(final int[] arr) {
        Stack<Integer> stack = new Stack<>();

//        int cur = 0;
//        while (cur < arr.length && arr[cur] == 0)
//            ++cur;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {

            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = (i - stack.peek() - 1);
                int height = Math.min(arr[i], arr[stack.peek()]) - arr[top];
                ans += (distance * height);
            }
            stack.push(i);
        }
        return ans;
    }

}
