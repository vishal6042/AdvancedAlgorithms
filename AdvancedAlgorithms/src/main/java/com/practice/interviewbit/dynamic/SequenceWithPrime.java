package com.practice.interviewbit.dynamic;

import java.util.Arrays;

public class SequenceWithPrime {
    public int[] solve(int A, int B, int C, int D) {
        int[] solve = new int[D];

        int nextA = A;
        int nextB = B;
        int nextC = C;

        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        for (int i = 0; i < D; i++) {
            int min = Math.min(nextA, Math.min(nextB, nextC));
            solve[i] = min;
            if (min == nextA) {

                nextA = solve[c1] * A;
                c1++;
            }
            if (min == nextB) {

                nextB = solve[c2] * B;
                c2++;
            }
            if (min == nextC) {

                nextC = solve[c3] * C;
                c3++;
            }
        }
        return solve;
    }

    public static void main(String[] args) {
        int a[] = new SequenceWithPrime().solve(2, 3, 5, 10);
        Arrays.stream(a).forEach(System.out::println);
    }
}
