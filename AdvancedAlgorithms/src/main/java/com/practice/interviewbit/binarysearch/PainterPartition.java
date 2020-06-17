package com.practice.interviewbit.binarysearch;

/**
 * https://www.interviewbit.com/problems/painters-partition-problem/
 * <p>
 * Given 2 integers A and B and an array of integars C of size N.
 * <p>
 * Element C[i] represents length of ith board.
 * <p>
 * You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of board.
 * <p>
 * Calculate and return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board.
 * <p>
 * 2 painters cannot share a board to paint. That is to say, a board
 * cannot be painted partially by one painter, and partially by another.
 * A painter will only paint contiguous boards. Which means a
 * configuration where painter 1 paints board 1 and 3 but not 2 is
 * invalid.
 * Return the ans % 10000003
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument given is the integer A.
 * The second argument given is the integer B.
 * The third argument given is the integer array C.
 * Output Format
 * <p>
 * Return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board % 10000003.
 * Constraints
 * <p>
 * 1 <=A <= 1000
 * 1 <= B <= 10^6
 * 1 <= C.size() <= 10^5
 * 1 <= C[i] <= 10^6
 * For Example
 * <p>
 * Input 1:
 * A = 2
 * B = 5
 * C = [1, 10]
 * Output 1:
 * 50
 * Explanation 1:
 * Possibility 1:- same painter paints both blocks, time taken = 55units
 * Possibility 2:- Painter 1 paints block 1, painter 2 paints block 2, time take = max(5, 50) = 50
 * There are no other distinct ways to paint boards.
 * ans = 50%10000003
 * <p>
 * Input 2:
 * A = 10
 * B = 1
 * C = [1, 8, 11, 3]
 * Output 2:
 * 11
 */
public class PainterPartition {
    private static final long MOD = 10000003;

    public static void main(String[] args) {
        PainterPartition pp = new PainterPartition();
        System.out.println(pp.paint(2, 1, new int[]{1, 8, 11, 3}));
    }

    public int paint(int noPainters, int unitTime, int[] arr) {
        long low = 0;
        long high = 0;

        for (int i = 0; i < arr.length; i++) {
            high = high % MOD + arr[i] % MOD;
        }

        high = high * unitTime;
        long ans = high % MOD;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isPossible(arr, mid, noPainters)) {
                ans = mid % MOD;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) ((ans * unitTime) % MOD);
    }

    private boolean isPossible(int[] arr, long mid, int noPainters) {
        int painter = 1;
        long painting = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > mid) {
                return false;
            }
            if (arr[i] + painting > mid) {
                ++painter;
                painting = arr[i];
                if (painter > noPainters) {
                    return false;
                }
            } else {
                painting += arr[i];
            }
        }
        return true;
    }

}
