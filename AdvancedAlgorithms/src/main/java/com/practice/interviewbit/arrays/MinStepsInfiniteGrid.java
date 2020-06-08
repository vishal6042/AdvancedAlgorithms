package com.practice.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Scanner;

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
