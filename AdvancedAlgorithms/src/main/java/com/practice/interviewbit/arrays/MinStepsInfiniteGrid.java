package com.practice.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
 * <p>
 * You are in an infinite 2D grid where you can move in any of the 8 directions :
 * <p>
 * (x,y) to
 * (x+1, y),
 * (x - 1, y),
 * (x, y+1),
 * (x, y-1),
 * (x-1, y-1),
 * (x+1,y+1),
 * (x-1,y+1),
 * (x+1,y-1)
 * You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.
 * <p>
 * Input :
 * <p>
 * Given two integer arrays A and B, where A[i] is x coordinate and B[i] is y coordinate of ith point respectively.
 * Output :
 * <p>
 * Return an Integer, i.e minimum number of steps.
 * Example :
 * <p>
 * Input : [(0, 0), (1, 1), (1, 2)]
 * Output : 2
 * It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
 */
public class MinStepsInfiniteGrid {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MinStepsInfiniteGrid minStepsInfiniteGrid = new MinStepsInfiniteGrid();
        ArrayList<Integer> xList = new ArrayList<>();
        ArrayList<Integer> yList = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            xList.add(scanner.nextInt());
            yList.add(scanner.nextInt());

        }
        int minSteps = minStepsInfiniteGrid.coverPoints(xList, yList);
        System.out.println(minSteps);
    }

    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int ans = 0;
        for (int i = 1; i < A.size(); i++) {
            ans += Math.max(Math.abs(A.get(i) - A.get(i - 1)), Math.abs(B.get(i) - B.get(i - 1)));
        }
        return ans;
    }


}
