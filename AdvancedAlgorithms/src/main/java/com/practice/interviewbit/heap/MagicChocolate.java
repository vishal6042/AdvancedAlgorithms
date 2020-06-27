package com.practice.interviewbit.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MagicChocolate {
    public static final int MOD = 1000000007;

    public int nchoc(int time, ArrayList<Integer> chocolates) {

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
        heap.addAll(chocolates);

        int ans = 0;
        for (int i = 0; i < time; i++) {
            if (!heap.isEmpty()) {
                int max = heap.peek();
                heap.poll();

                ans = (ans % MOD + max % MOD) % MOD;
                heap.add((int) Math.floor(max >> 1));
            }
        }
        return ans % MOD;
    }

    public static void main(String[] args) {
        System.out.println(
                new MagicChocolate().nchoc(10, new ArrayList<>(Arrays.asList( 2147483647, 2000000014, 2147483647)))
        );
    }
}
