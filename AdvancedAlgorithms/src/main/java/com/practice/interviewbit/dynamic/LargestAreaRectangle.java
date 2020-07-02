package com.practice.interviewbit.dynamic;

public class LargestAreaRectangle {
    public int solve(int[][] A) {
        if (A.length == 0) {
            return 0;
        }
        int row = A.length;
        int col = A[0].length;
        int[][] dp = new int[row + 1][col + 1];

        for (int i = 0; i < col; i++) {
            dp[0][i] = A[0][i];
            for (int j = 1; j < row; j++) {
                dp[j][i] = (A[j][i] == 0) ? 0 : dp[j - 1][i] + 1;
            }
        }
        for (int i = 0; i < row; i++) {
            int count[] = new int[row + 1];
            for (int j = 0; j < col; j++) {
                count[dp[i][j]]++;
            }

            int coln = 0;
            for (int j = row; j >= 0; j--) {
                if (count[j] > 0) {
                    for (int k = 0; k < count[j]; k++) {
                        dp[i][coln] = j;
                        coln++;
                    }
                }
            }
        }

        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                int currArea = (j + 1) * dp[i][j];
                maxArea = Math.max(maxArea, currArea);

            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int mat[][] = {{0, 1, 0, 1, 0},
                {0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0}};
        System.out.println(new LargestAreaRectangle().solve(mat));
    }

}
