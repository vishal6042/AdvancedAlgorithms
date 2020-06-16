package com.practice.interviewbit.math;

/**
 * https://www.interviewbit.com/problems/sum-of-pairwise-hamming-distance/
 * <p>
 * Hamming distance between two non-negative integers is defined as the number of positions at which the corresponding bits are different.
 * <p>
 * For example,
 * <p>
 * HammingDistance(2, 7) = 2, as only the first and the third bit differs in the binary representation of 2 (010) and 7 (111).
 * <p>
 * Given an array of N non-negative integers, find the sum of hamming distances of all pairs of integers in the array.
 * Return the answer modulo 1000000007.
 * <p>
 * Example
 * <p>
 * Let f(x, y) be the hamming distance defined above.
 * <p>
 * A=[2, 4, 6]
 * <p>
 * We return,
 * f(2, 2) + f(2, 4) + f(2, 6) +
 * f(4, 2) + f(4, 4) + f(4, 6) +
 * f(6, 2) + f(6, 4) + f(6, 6) =
 * <p>
 * 0 + 2 + 1
 * 2 + 0 + 1
 * 1 + 1 + 0 = 8
 */
public class SumOfPairWiseHammingDistance {
    public static void main(String[] args) {
        SumOfPairWiseHammingDistance sp = new SumOfPairWiseHammingDistance();
        int ans = sp.hammingDistance(new int[]{2, 4, 6});
        System.out.println(ans);
    }

    public int hammingDistance(final int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int value : A) {
                if ((value & (1 << i)) == 0) {
                    count++;
                }
            }
            ans += (((count * (A.length - count)) % 1000000007 * 2)) % 1000000007;
        }
        return ans;

    }
}
