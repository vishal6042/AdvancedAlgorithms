package com.practice.interviewbit.binarysearch;

/**
 * https://www.interviewbit.com/problems/matrix-median/
 * <p>
 * Given a matrix of integers A of size N x M in which each row is sorted.
 * <p>
 * Find an return the overall median of the matrix A.
 * <p>
 * Note: No extra memory is allowed.
 * <p>
 * Note: Rows are numbered from top to bottom and columns are numbered from left to right.
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first and only argument given is the integer matrix A.
 * Output Format
 * <p>
 * Return the overall median of the matrix A.
 * Constraints
 * <p>
 * 1 <= N, M <= 10^5
 * 1 <= N*M  <= 10^6
 * 1 <= A[i] <= 10^9
 * N*M is odd
 * For Example
 * <p>
 * Input 1:
 * A = [   [1, 3, 5],
 * [2, 6, 9],
 * [3, 6, 9]   ]
 * Output 1:
 * 5
 * Explanation 1:
 * A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
 * Median is 5. So, we return 5.
 * <p>
 * Input 2:
 * A = [   [5, 17, 100]    ]
 * Output 2:
 * 17 ``` Matrix=
 */
public class MatrixMedian {

    public static void main(String[] args) {
        MatrixMedian mm = new MatrixMedian();
        int ans = mm.findMedian(new int[][]{{1, 3, 5}, {2, 6, 9}, {3, 6, 9}});
        System.out.println(ans);
    }

    public int findMedian(int[][] A) {
        int r = A.length;
        int c = A[0].length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < r; ++i) {
            if (A[i][0] < min) {
                min = A[i][0];
            }
            if (A[i][c - 1] > max) {
                max = A[i][c - 1];
            }
        }

        int required = (r * c + 1) / 2;
        while (min < max) {
            int mid = min + (max - min) / 2;
            int count = 0;
            int index = 0;
            for (int[] ints : A) {
                index = find(ints, mid);

                if (index < 0) {
                    index = Math.abs(index) - 1;
                } else {
                    while (index < c && ints[index] == mid) {
                        index += 1;
                    }
                }
                count += index;
            }
            if (count < required) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    private int find(int[] a, int elem) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == elem) {
                return mid;
            } else if (a[mid] > elem) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -(low + 1);
    }
}
