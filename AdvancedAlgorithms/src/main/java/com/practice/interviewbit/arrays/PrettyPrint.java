package com.practice.interviewbit.arrays;

/**
 * https://www.interviewbit.com/problems/prettyprint/
 * <p>
 * Print concentric rectangular pattern in a 2d matrix.
 * Let us show you some examples to clarify what we mean.
 * <p>
 * Example 1:
 * <p>
 * Input: A = 4.
 * Output:
 * <p>
 * 4 4 4 4 4 4 4
 * 4 3 3 3 3 3 4
 * 4 3 2 2 2 3 4
 * 4 3 2 1 2 3 4
 * 4 3 2 2 2 3 4
 * 4 3 3 3 3 3 4
 * 4 4 4 4 4 4 4
 * Example 2:
 * <p>
 * Input: A = 3.
 * Output:
 * <p>
 * 3 3 3 3 3
 * 3 2 2 2 3
 * 3 2 1 2 3
 * 3 2 2 2 3
 * 3 3 3 3 3
 * The outermost rectangle is formed by A, then the next outermost is formed by A-1 and so on.
 * <p>
 * You will be given A as an argument to the function you need to implement, and you need to return a 2D array.
 */
public class PrettyPrint {

    public static void main(String[] args) {
        int a[][] = new PrettyPrint().prettyPrint(5);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] prettyPrint(int A) {
        int[][] mat = new int[2 * A - 1][2 * A - 1];

        int row = 0;
        int col = 0;
        int rowMax = 2 * A - 1;
        int colMax = 2 * A - 1;

        while (row < rowMax && col < colMax) {
            for (int i = col; i < colMax; i++) {
                mat[row][i] = A;
            }
            row++;
            for (int i = row; i < rowMax; i++) {
                mat[i][colMax - 1] = A;
            }
            colMax--;
            if (row < rowMax) {
                for (int i = colMax - 1; i >= col; i--) {
                    mat[rowMax - 1][i] = A;
                }
                rowMax--;
            }
            if (col < colMax) {
                for (int i = rowMax - 1; i >= row; i--) {
                    mat[i][col] = A;
                }
                col++;
            }
            A--;
        }
        return mat;
    }
}
