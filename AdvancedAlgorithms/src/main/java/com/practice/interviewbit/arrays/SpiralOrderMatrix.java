package com.practice.interviewbit.arrays;

/**
 * https://www.interviewbit.com/problems/spiral-order-matrix-ii/
 * <p>
 * Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.
 * <p>
 * <p>
 * <p>
 * Input Format:
 * <p>
 * The first and the only argument contains an integer, A.
 * Output Format:
 * <p>
 * Return a 2-d matrix of size A x A satisfying the spiral order.
 * Constraints:
 * <p>
 * 1 <= A <= 1000
 * Examples:
 * <p>
 * Input 1:
 * A = 3
 * <p>
 * Output 1:
 * [   [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]   ]
 * <p>
 * Input 2:
 * 4
 * <p>
 * Output 2:
 * [   [1, 2, 3, 4],
 * [12, 13, 14, 5],
 * [11, 16, 15, 6],
 * [10, 9, 8, 7]   ]
 */
public class SpiralOrderMatrix {
    public static void main(String[] args) {
        int arr[][] = new SpiralOrderMatrix().generateMatrix(5);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int A) {
        int ans[][] = new int[A][A];

        int row = 0;
        int col = 0;
        int count = 1;
        int rowMax = A;
        int colMax = A;
        while (row < rowMax && col < colMax) {
            for (int i = col; i < colMax; i++) {
                ans[row][i] = count++;
            }
            row++;

            for (int i = row; i < rowMax; i++) {
                ans[i][colMax - 1] = count++;
            }
            colMax--;
            if (row < rowMax) {
                for (int i = colMax - 1; i >= col; i--) {
                    ans[rowMax - 1][i] = count++;
                }
                rowMax--;
            }
            if (col < colMax) {
                for (int i = rowMax - 1; i >= row; --i) {
                    ans[i][col] = count++;
                }
                col++;
            }
        }

        return ans;
    }
}
