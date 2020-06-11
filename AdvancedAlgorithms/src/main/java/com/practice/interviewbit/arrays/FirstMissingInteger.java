package com.practice.interviewbit.arrays;

/**
 * https://www.interviewbit.com/problems/first-missing-integer/
 * <p>
 * Given an unsorted integer array, find the first missing positive integer.
 * <p>
 * Example:
 * <p>
 * Given [1,2,0] return 3,
 * <p>
 * [3,4,-1,1] return 2,
 * <p>
 * [-8, -7, -6] returns 1
 * <p>
 * Your algorithm should run in O(n) time and use constant space.
 */
public class FirstMissingInteger {

    public static void main(String[] args) {
        int A[] = {3, 4, -1, 1};
        System.out.println(new FirstMissingInteger().firstMissingPositiveWithoutExtraSpace(A));
    }

    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        boolean db[] = new boolean[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0 && A[i] <= A.length) {
                db[A[i]] = true;
            }
        }
        for (int i = 1; i < db.length; i++) {
            if (!db[i]) {
                return i;
            }
        }
        return A.length + 1;


    }

    /**
     * not working
     *
     * @param A
     * @return
     */
    public int firstMissingPositiveWithoutExtraSpace(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        boolean isAllNeg = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > 0) {
                isAllNeg = false;
                break;
            }
        }
        if (isAllNeg) {
            return 1;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0 && A[i] <= A.length) {
                A[A[i] - 1] = -A[A[i] - 1];
            }
        }
        for (int i = 1; i < A.length; i++) {
            if (A[i] >= 0) {
                return i + 1;
            }
        }
        return A.length + 1;


    }
}
