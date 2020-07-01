package com.practice.interviewbit.greedy;

public class GasStation {
    public int canCompleteCircuit(final int[] A, final int[] B) {

        int total = A.length;
        if (total == 1) {
            if (A[0] < B[0]) {
                return -1;
            }
            return 0;
        }
        int start = 0;
        int end = 1;
        int gas = A[start] - B[start];
        while (start != end || gas < 0) {

            while (gas < 0 && start != end) {
                gas = gas - (A[start] - B[start]);
                start = (start + 1) % total;
                if (start == 0) {
                    return -1;
                }
            }
            gas = gas + (A[end] - B[end]);
            end = (end + 1) % total;
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(
                new GasStation().canCompleteCircuit(
                        new int[]{4, 6, 7, 4},
                        new int[]{6, 5, 3, 5}
                )
        );

        System.out.println(
                new GasStation().canCompleteCircuit(
                        new int[]{0},
                        new int[]{0}
                )
        );
    }
}
