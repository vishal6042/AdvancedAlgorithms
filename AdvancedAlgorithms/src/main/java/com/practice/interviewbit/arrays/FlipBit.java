package com.practice.interviewbit.arrays;

/**
 * https://www.interviewbit.com/problems/flip/
 * <p>
 * You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.
 * <p>
 * Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised. If you don’t want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.
 * <p>
 * Notes:
 * <p>
 * Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
 * For example,
 * <p>
 * S = 010
 * <p>
 * Pair of [L, R] | Final string
 * _______________|_____________
 * [1 1]          | 110
 * [1 2]          | 100
 * [1 3]          | 101
 * [2 2]          | 000
 * [2 3]          | 001
 * <p>
 * We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
 * Another example,
 * <p>
 * If S = 111
 * <p>
 * No operation can give us more than three 1s in final string. So, we return empty array [].
 */
public class FlipBit {
    public static void main(String[] args) {
        int arr[] = new FlipBit().flip("111010"); // 111101 (1,3)
        if (arr.length == 2) {
            System.out.println(arr[0] + " " + arr[1]);
        }
    }

    public int[] flip(String A) {
        int max = 0;
        int maxHere = 0;
        int[] ans = new int[2];
        int start = 0;
        boolean isDone = false;
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            maxHere += (c == '0') ? 1 : -1;
            if (maxHere < 0) {
                maxHere = 0;
                start = (c == '0') ? i : i + 1;
            } else {
                if (max < maxHere) {
                    max = maxHere;
                    ans[0] = start;
                    ans[1] = i;
                    isDone = true;
                }
            }
        }
        if (!isDone) {
            return new int[0];
        }
        ans[0] += 1;
        ans[1] += 1;
        return ans;
    }
}
