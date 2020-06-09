package com.practice.interviewbit.arrays;

/**
 * https://www.interviewbit.com/problems/anti-diagonals/
 * <p>
 * Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.
 * <p>
 * Example:
 * <p>
 * <p>
 * Input:
 * <p>
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * <p>
 * Return the following :
 * <p>
 * [
 * [1],
 * [2, 4],
 * [3, 5, 7],
 * [6, 8],
 * [9]
 * ]
 * <p>
 * <p>
 * Input :
 * 1 2
 * 3 4
 * <p>
 * Return the following  :
 * <p>
 * [
 * [1],
 * [2, 3],
 * [4]
 * ]
 */
public class ArrayOfAntiDiagonals {

    public static void main(String[] args) {
        int a[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int arr[][] = new ArrayOfAntiDiagonals().diagonal(a);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] diagonal(int[][] A) {
        int n = A.length;
        int rowMax = 1 + (n - 1) * 2;
        int ans[][] = new int[rowMax][];

        for (int i = 0; i < rowMax; i++) {
            if (i < n) {
                ans[i] = new int[i + 1];
            } else {
                ans[i] = new int[rowMax - i];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j < n) {
                    ans[i + j][i] = A[i][j];
                } else {
                    ans[i + j][Math.abs(n - (j + 1))] = A[i][j];
                }
            }
        }
        return ans;
    }
}
