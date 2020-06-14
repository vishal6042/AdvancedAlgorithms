package com.practice.interviewbit.arrays;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/set-matrix-zeros/
 * <p>
 * Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.
 * <p>
 * Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.
 * <p>
 * <p>
 * <p>
 * Input Format:
 * <p>
 * The first and the only argument of input contains a 2-d integer matrix, A, of size M x N.
 * Output Format:
 * <p>
 * Return a 2-d matrix that satisfies the given conditions.
 * Constraints:
 * <p>
 * 1 <= N, M <= 1000
 * 0 <= A[i][j] <= 1
 * Examples:
 * <p>
 * Input 1:
 * [   [1, 0, 1],
 * [1, 1, 1],
 * [1, 1, 1]   ]
 * <p>
 * Output 1:
 * [   [0, 0, 0],
 * [1, 0, 1],
 * [1, 0, 1]   ]
 * <p>
 * Input 2:
 * [   [1, 0, 1],
 * [1, 1, 1],
 * [1, 0, 1]   ]
 * <p>
 * Output 2:
 * [   [0, 0, 0],
 * [1, 0, 1],
 * [0, 0, 0]   ]
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> one = new ArrayList<>();
        one.add(1);
        one.add(0);
        one.add(1);

        ArrayList<Integer> two = new ArrayList<>();
        two.add(1);
        two.add(1);
        two.add(1);

        ArrayList<Integer> three = new ArrayList<>();
        three.add(1);
        three.add(1);
        three.add(1);

        a.add(one);
        a.add(two);
        a.add(three);
        System.out.println(a);
        new SetMatrixZeroes().setZeroes(a);
        System.out.println(a);
    }

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        if (a == null || a.size() == 0) {
            return;
        }

        boolean rowFlag = false;
        boolean colFlag = false;
        for (int i = 0; i < a.get(0).size(); i++) {
            if (a.get(0).get(i) == 0) {
                rowFlag = true;
                break;
            }
        }
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).get(0) == 0) {
                colFlag = true;
                break;
            }
        }
        for (int i = 1; i < a.size(); i++) {
            for (int j = 1; j < a.get(i).size(); j++) {
                if (a.get(i).get(j) == 0) {
                    a.get(0).set(j, 0);
                    a.get(i).set(0, 0);
                }
            }
        }
        for (int i = 1; i < a.size(); i++) {
            for (int j = 1; j < a.get(i).size(); j++) {
                if (a.get(0).get(j) == 0 || a.get(i).get(0) == 0) {
                    a.get(i).set(j, 0);
                }
            }
        }
        if (rowFlag) {
            for (int i = 0; i < a.get(0).size(); ++i) {
                a.get(0).set(i, 0);
            }
        }

        if (colFlag) {
            for (int i = 0; i < a.size(); ++i) {
                a.get(i).set(0, 0);
            }
        }
    }
}
