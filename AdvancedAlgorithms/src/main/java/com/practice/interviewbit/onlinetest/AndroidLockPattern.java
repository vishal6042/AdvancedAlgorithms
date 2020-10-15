package com.practice.interviewbit.onlinetest;

import java.util.Arrays;

/**
 * Valid Rule: Each pattern must connect at least m keys and atmost n keys
 * if the lines connecting two consecutive keys in the pattern passes through any other keys,
 * the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
 */
public class AndroidLockPattern {

    public static final int NOT_VISITED = -1;
    private static boolean[] visited = new boolean[9];

    public static void main(String[] args) {
        System.out.println(calculate(2, 2));
    }

    private static int calculate(int m, int n) {
        int res = 0;

        for (int i = m; i <= n; i++) {
            res += solve(NOT_VISITED, i);
            Arrays.fill(visited, false);
        }
        return res;

    }

    private static int solve(int last, int len) {
        if (len == 0) {
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            if (isValid(i, last)) {
                visited[i] = true;
                sum += solve(i, len - 1);
                visited[i] = false;
            }
        }
        return sum;
    }

    private static boolean isValid(int index, int last) {
        if (visited[index]) {
            return false;
        }
        if (last == NOT_VISITED) {
            return true;
        }

        // adjacent cell in row or column
        if ((last + index) % 2 == 1) {
            return true;
        }

        int mid = (last + index) / 2;
        if (mid == 4) {
            return visited[mid];
        }
        if ((index % 3 != last % 3) && (index / 3 != last / 3)) {
            return true;
        }
        return visited[mid];
    }
}
