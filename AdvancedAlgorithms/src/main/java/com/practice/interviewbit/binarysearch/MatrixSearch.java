package com.practice.interviewbit.binarysearch;

/**
 * https://www.interviewbit.com/problems/matrix-search/
 * <p>
 * Given a matrix of integers A of size N x M and an integer B.
 * <p>
 * Write an efficient algorithm that searches for integar B in matrix A.
 * <p>
 * This matrix A has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than or equal to the last integer of the previous row.
 * Return 1 if B is present in A, else return 0.
 * <p>
 * Note: Rows are numbered from top to bottom and columns are numbered from left to right.
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument given is the integer matrix A.
 * The second argument given is the integer B.
 * Output Format
 * <p>
 * Return 1 if B is present in A, else return 0.
 * Constraints
 * <p>
 * 1 <= N, M <= 1000
 * 1 <= A[i][j], B <= 10^6
 * For Example
 * <p>
 * Input 1:
 * A =
 * [ [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]  ]
 * B = 3
 * Output 1:
 * 1
 * <p>
 * Input 2:
 * A = [   [5, 17, 100, 111]
 * [119, 120,  127,   131]    ]
 * B = 3
 * Output 2:
 * 0
 */
public class MatrixSearch {

    public static void main(String[] args) {
        int arr[][] = {{1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};

        MatrixSearch ms = new MatrixSearch();
        System.out.println(ms.searchMatrix(arr, 23));
    }

    public int searchMatrix(int[][] arr, int key) {

        int rowC = arr.length;
        int colC = arr[0].length;
        int i = 0;
        int j = colC - 1;
        while (i < rowC && j >= 0) {
            if (arr[i][j] == key) {
                return 1;
            } else if (arr[i][j] > key) {
                j--;
            } else {
                i++;
            }
        }
        return 0;
    }
}
