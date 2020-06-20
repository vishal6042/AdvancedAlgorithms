package com.practice.interviewbit.twopointer;

import java.util.Arrays;
import java.util.TreeSet;

public class ThreeSumZero {
    public static void main(String[] args) {
        ThreeSumZero threeSumZero = new ThreeSumZero();
        int[][] ans = threeSumZero.threeSum(new int[]{2147483647, -2147483648, -2147483648, 0, 1});
        for (int[] an : ans) {
            for (int i1 = 0; i1 < 3; i1++) {
                System.out.print(an[i1] + " ");
            }
            System.out.println();
        }
    }

    public int[][] threeSum(int[] A) {
        if (A == null) {
            return null;
        }
        TreeSet<String> treeSet = new TreeSet<>();
        int[][] ans = new int[A.length][3];
        int count = 0;
        quickSort(A, 0, A.length - 1);
        for (int i = 0; i < A.length - 2; i++) {
            int j = i + 1;
            int k = A.length - 1;

            while (j < k) {
                long sum = (long) A[i] + A[j] + A[k];
                if (sum == 0) {
                    String val = A[i] + "_" + A[j] + "_" + A[k];
                    if (!treeSet.contains(val)) {
                        treeSet.add(val);

                        ans[count][0] = A[i];
                        ans[count][1] = A[j];
                        ans[count][2] = A[k];
                        count++;
                    }
                    j++;
                    k--;

                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        int[][] finalAns = new int[count][3];
        for (int i = 0; i < count; i++) {
            finalAns[i] = Arrays.copyOfRange(ans[i], 0, 3);
        }
        return finalAns;
    }

    private void quickSort(int[] a, int start, int end) {
        if (start < end) {
            int part = findPartition(a, start, end);
            quickSort(a, start, part - 1);
            quickSort(a, part + 1, end);
        }
    }

    private int findPartition(int[] a, int start, int end) {
        int pivotElem = a[end];
        int pivotIndex = start;

        for (int i = start; i < end; i++) {
            if (a[i] <= pivotElem) {
                swap(a, i, pivotIndex);
                pivotIndex++;
            }
        }
        swap(a, pivotIndex, end);
        return pivotIndex;
    }

    private void swap(int a[], int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
