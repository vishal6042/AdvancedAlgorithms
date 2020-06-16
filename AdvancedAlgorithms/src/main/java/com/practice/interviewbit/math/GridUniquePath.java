package com.practice.interviewbit.math;

public class GridUniquePath {
    public static void main(String[] args) {
        GridUniquePath path = new GridUniquePath();
        System.out.println(path.uniquePaths(100, 1));
    }

    int count = 0;

    public int uniquePaths(int A, int B) {
        doDfs(0, 0, A - 1, B - 1);
        return count;
    }

    private void doDfs(int startX, int startY, int endX, int endY) {
        if (startX == endX && startY == endY) {
            count++;
            return;
        }
        if (isSafe(startX + 1, startY, endX, endY)) {
            doDfs(startX + 1, startY, endX, endY);
        }
        if (isSafe(startX, startY + 1, endX, endY)) {
            doDfs(startX, startY + 1, endX, endY);
        }

    }

    private boolean isSafe(int x, int y, int rowMax, int colMax) {
        if (x >= 0 && x <= rowMax && y >= 0 && y <= colMax) {
            return true;
        }
        return false;
    }
}
