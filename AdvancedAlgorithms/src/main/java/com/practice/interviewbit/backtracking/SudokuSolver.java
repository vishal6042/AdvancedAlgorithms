package com.practice.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class SudokuSolver {
    public void solveSudoku(ArrayList<ArrayList<Character>> board) {
        solveSudokuUtil(board, 0, 0);
    }

    private boolean solveSudokuUtil(ArrayList<ArrayList<Character>> board, int row, int col) {
        if (col == 9) {
            row = row + 1;
            col = 0;
        }
        if (row == 9) {
            return true;
        }
        if (board.get(row).get(col) != '.') {
            return solveSudokuUtil(board, row, col + 1);
        }

        for (int i = 1; i <= 9; i++) {
            if (isSafe(board, row, col, i)) {
                board.get(row).set(col, (char) (i + '0'));
                if (solveSudokuUtil(board, row, col + 1)) {
                    return true;
                }
                board.get(row).set(col, '.');
            }
        }
        return false;

    }

    private boolean isSafe(ArrayList<ArrayList<Character>> board, int row, int col, int i) {
        for (Character character : board.get(row)) {
            if (character.equals((char) (i + '0'))) {
                return false;
            }
        }
        for (int j = 0; j < 9; j++) {
            if (board.get(j).get(col).equals((char) (i + '0'))) {
                return false;
            }
        }

        if ((row % 3) != 0) {
            row -= (row % 3);
        }
        if ((col % 3) != 0) {
            col -= (col % 3);
        }

        for (int j = row; j < row + 3; j++) {
            for (int k = col; k < col + 3; k++) {
                if (board.get(j).get(k).equals((char) (i + '0'))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> board = new ArrayList<>();
        board.add(new ArrayList<>(Arrays.asList('5', '3', '4', '6', '7', '.', '9', '.', '2')));
        board.add(new ArrayList<>(Arrays.asList('.', '7', '.', '1', '9', '5', '3', '4', '8')));
        board.add(new ArrayList<>(Arrays.asList('1', '9', '.', '3', '4', '2', '5', '6', '.')));
        board.add(new ArrayList<>(Arrays.asList('8', '.', '9', '7', '6', '.', '4', '2', '3')));
        board.add(new ArrayList<>(Arrays.asList('.', '.', '6', '8', '.', '3', '7', '9', '.')));
        board.add(new ArrayList<>(Arrays.asList('7', '1', '3', '.', '2', '.', '8', '.', '6')));
        board.add(new ArrayList<>(Arrays.asList('9', '6', '1', '.', '3', '.', '2', '8', '4')));
        board.add(new ArrayList<>(Arrays.asList('2', '8', '7', '4', '.', '9', '.', '.', '5')));
        board.add(new ArrayList<>(Arrays.asList('3', '.', '5', '2', '.', '6', '1', '7', '.')));

        new SudokuSolver().solveSudoku(board);
        board.forEach(characters -> {
            for (Character chars : characters) {
                System.out.print(chars + " ");
            }
            System.out.println();
        });
    }
}
