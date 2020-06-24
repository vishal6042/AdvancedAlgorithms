package com.practice.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidSudoku {
    public int isValidSudoku(final List<String> sudoku) {
        int[][] rowHash = new int[9][9];
        int[][] colHash = new int[9][9];
        int[][] boxHash = new int[9][9];

        for (int i = 0; i < sudoku.size(); i++) {
            String row = sudoku.get(i);
            for (int j = 0; j < row.length(); j++) {
                if (row.charAt(j) == '.') {
                    continue;
                } else {
                    if (!isValid(i, j, sudoku, row.charAt(j), rowHash, colHash, boxHash)) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    private boolean isValid(int i, int j, List<String> sudoku,
                            char c, int[][] rowHash, int[][] colHash, int[][] boxHash) {

        return checkRow(rowHash, i, c) && checkCol(colHash, j, c) && checkBox(boxHash, i, j, c);

    }

    private boolean checkBox(int[][] boxHash, int i, int j, char c) {
        if (i % 3 != 0)
            i -= i % 3;
        if (j % 3 != 0)
            j -= j % 3;
        int boxRow = 0;
        if (i == 0) {
            if (j == 0) {
                boxRow = 0;
            } else if (j == 3) {
                boxRow = 1;
            } else if (j == 6) {
                boxRow = 2;
            }
        } else if (i == 3) {
            if (j == 0) {
                boxRow = 3;
            } else if (j == 3) {
                boxRow = 4;
            } else if (j == 6) {
                boxRow = 5;
            }
        } else if (i == 6) {
            if (j == 0) {
                boxRow = 6;
            } else if (j == 3) {
                boxRow = 7;
            } else if (j == 6) {
                boxRow = 8;
            }
        }

        if (boxHash[boxRow][(c - '0') - 1] > 0) {
            return false;
        }
        boxHash[boxRow][(c - '0') - 1]++;
        return true;

    }

    private boolean checkCol(int[][] colHash, int j, char c) {
        if (colHash[(c - '0') - 1][j] > 0) {
            return false;
        }
        colHash[(c - '0') - 1][j]++;
        return true;
    }

    private boolean checkRow(int[][] rowHash, int i, char c) {
        if (rowHash[i][(c - '0') - 1] > 0) {
            return false;
        }

        rowHash[i][(c - '0') - 1]++;
        return true;

    }

    public static void main(String[] args) {
        System.out.println(
                new ValidSudoku().isValidSudoku(
                        new ArrayList<>(
                                Arrays.asList("53..7....",
                                        "6..195...",
                                        ".98....6.",
                                        "8...6...3",
                                        "4..8.3..1",
                                        "7.8.2...6",
                                        ".6....28.",
                                        "...419..5",
                                        "....8..79")
                        )
                )
        );
    }
}
