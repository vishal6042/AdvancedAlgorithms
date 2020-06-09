package com.practice.interviewbit.arrays;

/**
 * https://www.interviewbit.com/problems/pascal-triangle/
 * Given numRows, generate the first numRows of Pascal’s triangle.
 * <p>
 * Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.
 * <p>
 * Example:
 * <p>
 * Given numRows = 5,
 * <p>
 * Return
 * <p>
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class PascalTriangle {
    public static void main(String[] args) {
        int arr[][] = new PascalTriangle().solve(5);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] solve(int A) {
        int ans[][] = new int[A][];
        if (A == 0) {
            return ans;
        }
        ans[0] = new int[1];
        ans[0][0] = 1;
        if (A == 1) {
            return ans;
        }
        ans[1] = new int[2];
        ans[1][0] = 1;
        ans[1][1] = 1;
        if (A == 2) {
            return ans;
        }
        for (int i = 2; i < A; i++) {
            ans[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    ans[i][j] = 1;
                } else {
                    ans[i][j] = ans[i - 1][j] + ans[i - 1][j - 1];
                }
            }
        }
        return ans;
    }


}
