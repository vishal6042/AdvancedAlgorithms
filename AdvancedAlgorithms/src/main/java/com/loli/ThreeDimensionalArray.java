package com.loli;

import java.util.Scanner;

public class ThreeDimensionalArray {
    public static void main(String[] args) {
        int num, row, column, i, j, k, gt, st;

        Scanner sc = new Scanner(System.in);

        System.out.println("How Many Matrix You WAnt:--  ");
        num = sc.nextInt();
        System.out.println("How Many Row You WAnt:--  ");
        row = sc.nextInt();
        System.out.println("How Many column You WAnt:--  ");
        column = sc.nextInt();
        int[][][] arr = new int[num][row][column];

        for (i = 0; i < num; i++) {
            System.out.println("Enter value of " + (i + 1) + "Matrix");
            for (j = 0; j < row; j++) {
                for (k = 0; k < column; k++) {
                    arr[i][j][k] = sc.nextInt();
                }
            }
        }
        System.out.println("All Matrix Are:--");
        for (i = 0; i < num; i++) {
            System.out.println("Matrix:-- " + (i + 1));
            for (j = 0; j < row; j++) {
                for (k = 0; k < column; k++) {
                    System.out.print(arr[i][j][k] + "\t");
                }
                System.out.println();
            }
            System.out.println("Greatest Element in Matrix " + (i + 1) + " is " + findGreatest(arr[i]));
            System.out.println("Smallest Element in Matrix " + (i + 1) + " is " + findSmallest(arr[i]));

        }

    }

    private static int findGreatest(int[][] arr) {
        int largest = arr[0][0];
        for (int[] row : arr) {
            for (int elem : row) {
                if (elem > largest) {
                    largest = elem;
                }
            }
        }
        return largest;
    }

    private static int findSmallest(int[][] arr) {
        int smallest = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] < smallest) {
                    smallest = arr[i][j];
                }
            }
        }
        return smallest;
    }

}
