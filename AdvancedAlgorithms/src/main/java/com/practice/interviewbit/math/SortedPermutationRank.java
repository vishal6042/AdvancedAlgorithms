package com.practice.interviewbit.math;

/**
 * https://www.interviewbit.com/problems/sorted-permutation-rank/
 * <p>
 * Given a string, find the rank of the string amongst its permutations sorted lexicographically.
 * Assume that no characters are repeated.
 * <p>
 * Example :
 * <p>
 * Input : 'acb'
 * Output : 2
 * <p>
 * The order permutations with letters 'a', 'c', and 'b' :
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * The answer might not fit in an integer, so return your answer % 1000003
 */
public class SortedPermutationRank {


    public static void main(String[] args) {
        SortedPermutationRank spr = new SortedPermutationRank();
        //  System.out.println(spr.findRank("acb"));
        System.out.println(spr.findRank("DTNGJPURFHYEW"));
    }

    private static final int MOD = 1000003;

    public int findRank(String A) {
        if (A == null || A.isEmpty()) {
            return 0;
        }
        int rank = 1;
        int len = A.length();
        int fact = fact(len);
        //fact %= MOD;

        int count[] = new int[256];
        updateCountArray(A, count);

        for (int i = 0; i < len; i++) {
            fact = fact(len - i - 1);
            rank += ((count[A.charAt(i) - 1] % MOD) * (fact % MOD)) % MOD;
            //rank %= MOD;
            reduceCount(count, A.charAt(i));
        }
        return (rank % MOD);
    }

    private void reduceCount(int[] count, char charAt) {
        for (int i = charAt; i < 256; i++) {
            count[i]--;
        }
    }

    private void updateCountArray(String a, int[] count) {
        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i)]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
    }


    private int fact(int len) {
        if (len <= 1) {
            return 1;
        }
        return ((len % MOD) * (fact(len - 1) % MOD)) % MOD;
    }
}
