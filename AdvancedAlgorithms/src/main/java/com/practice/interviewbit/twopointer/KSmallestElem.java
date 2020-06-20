package com.practice.interviewbit.twopointer;

import java.util.Collections;
import java.util.PriorityQueue;

public class KSmallestElem {
    public int kthsmallest(final int[] A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < B; i++) {
            pq.add(A[i]);
        }

        for (int i = B; i < A.length; i++) {
            if (A[i] <= pq.peek()) {
                pq.poll();
                pq.add(A[i]);
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        System.out.println(
                new KSmallestElem().kthsmallest(
                        new int[]{2, 1, 4, 3, 2},
                        3
                )
        );
    }
}
