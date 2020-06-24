package com.practice.interviewbit.backtracking;

import java.util.ArrayList;

public class NQueen {
    static class Position {
        int row, col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        Position[] positions = new Position[n];
        solve(positions, ans, 0, n);
        return ans;
    }

    private void solve(Position[] positions, ArrayList<ArrayList<String>> ans, int curr, int n) {
        if (n == curr) {
            ArrayList<String> one = new ArrayList<>();
            StringBuilder builder = new StringBuilder();

            for (Position pos : positions) {
                for (int i = 0; i < n; i++) {
                    if (pos.col == i) {
                        builder.append("Q");
                    } else {
                        builder.append(".");
                    }
                }
                one.add(builder.toString());
                builder = new StringBuilder();
            }
            ans.add(one);
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean isSafe = true;
            for (int j = 0; j < curr; j++) {
                if (positions[j].col == i
                        || positions[j].col - positions[j].row == i - curr
                        || positions[j].col + positions[j].row == i + curr) {
                    isSafe = false;
                    break;
                }
            }
            if (isSafe) {
                positions[curr] = new Position(curr, i);
                solve(positions, ans, curr + 1, n);
            }
        }
    }

    public static void main(String[] args) {
        new NQueen().solveNQueens(4).forEach(strings -> {
            for (String val : strings) {
                System.out.println(val);
            }
            System.out.println("#################");
        });
    }


}
