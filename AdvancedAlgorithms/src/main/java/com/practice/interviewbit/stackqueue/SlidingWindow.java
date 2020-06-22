package com.practice.interviewbit.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindow {
    public int[] slidingMaximum(final int[] A, int B) {
        if (A == null) {
            return null;
        }
        int finalLength = B >= A.length ? 1 : A.length - B + 1;
        int ans[] = new int[finalLength];

        int wLeft = 0;
        int wRight = (finalLength == 1) ? A.length - 1 : B - 1;
        int max = Integer.MIN_VALUE;
        for (int i = wLeft; i <= wRight; i++) {
            if (max < A[i]) {
                max = A[i];
            }
        }
        if (finalLength == 1) {
            ans[0] = max;
            return ans;
        }
        wLeft++;
        wRight++;
        ans[0] = max;
        int count = 1;
        while (wRight < A.length) {
            if (A[wRight] >= max) {
                max = A[wRight];
            } else if (A[wLeft - 1] == max) {
                max = A[wLeft];
                for (int i = wLeft + 1; i <= wRight; i++) {
                    if (max < A[i]) {
                        max = A[i];
                    }
                }
            }
            ans[count++] = max;
            wLeft++;
            wRight++;
        }
        return ans;

    }

    public int[] slidingMaximumUsingDeque(final int[] A, int B) {
        if (A.length == 0 || B < 1) {
            return new int[0];
        }
        if (B > A.length) {
            B = A.length;
        }
        int ans[] = new int[A.length - B + 1];
        int count = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < A.length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - B + 1) {
                deque.poll();
            }

            while (!deque.isEmpty() && A[deque.peekLast()] < A[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= B - 1) {
                ans[count++] = A[deque.peek()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans[] = new SlidingWindow().slidingMaximumUsingDeque(
                new int[]{1, 3, -1, -3, 5, 3, 6, 7},
                3
        );
        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}
