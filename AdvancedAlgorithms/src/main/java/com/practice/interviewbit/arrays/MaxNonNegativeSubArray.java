package com.practice.interviewbit.arrays;

/**
 * https://www.interviewbit.com/problems/max-non-negative-subarray/
 * <p>
 * Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
 * <p>
 * The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
 * <p>
 * Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
 * <p>
 * Find and return the required subarray.
 * <p>
 * NOTE:
 * <p>
 * 1. If there is a tie, then compare with segment's length and return segment which has maximum length.
 * 2. If there is still a tie, then return the segment with minimum starting index.
 * <p>
 * <p>
 * Input Format:
 * <p>
 * The first and the only argument of input contains an integer array A, of length N.
 * Output Format:
 * <p>
 * Return an array of integers, that is a subarray of A that satisfies the given conditions.
 * Constraints:
 * <p>
 * 1 <= N <= 1e5
 * 1 <= A[i] <= 1e5
 * Examples:
 * <p>
 * Input 1:
 * A = [1, 2, 5, -7, 2, 3]
 * <p>
 * Output 1:
 * [1, 2, 5]
 * <p>
 * Explanation 1:
 * The two sub-arrays are [1, 2, 5] [2, 3].
 * The answer is [1, 2, 5] as its sum is larger than [2, 3].
 * <p>
 * Input 2:
 * A = [10, -1, 2, 3, -4, 100]
 * <p>
 * Output 2:
 * [100]
 * <p>
 * Explanation 2:
 * The three sub-arrays are [10], [2, 3], [100].
 * The answer is [100] as its sum is larger than the other two.
 */
public class MaxNonNegativeSubArray {

    public static void main(String[] args) {
        MaxNonNegativeSubArray maxNonNegativeSubArray = new MaxNonNegativeSubArray();
        //int arr[] = maxNonNegativeSubArray.maxset(new int[]{1, -2, 5, 6, -7, 8, 3});
        int arr[] = maxNonNegativeSubArray.maxset(new int[]{-1, -2, -5});
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int[] maxset(int[] A) {
        int maxSum = 0;
        int maxSoFar = 0;
        int start = 0;
        int prevStart = 0;
        int prevEnd = 0;
        int end = -1;
        int ansStart = -1;
        int ansEnd = -1;

        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                maxSoFar = 0;
                prevStart = start;
                prevEnd = end;
                start = i + 1;
                continue;
            }
            maxSoFar += A[i];
            if (maxSoFar > maxSum) {
                end = i;
                maxSum = maxSoFar;
                ansStart = start;
                ansEnd = end;
            } else if (maxSoFar == maxSum) {
                if (i - start > end - prevStart) {
                    prevStart = start;
                    prevEnd = end;
                    end = i;
                    ansStart = start;
                    ansEnd = end;
                } else {
                    ansStart = prevStart;
                    ansEnd = prevEnd;
                }
            }
        }
        if (ansEnd == -1 && ansStart == -1) {
            return new int[0];
        }
        int[] arr = new int[ansEnd - ansStart + 1];
        for (int i = ansStart; i <= ansEnd; i++) {
            arr[i - ansStart] = A[i];
        }
        return arr;
    }
}
