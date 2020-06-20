package com.practice.interviewbit.twopointer;

public class ThreeSum {
    public int threeSumClosest(int[] A, int B) {
        long ansSum = Integer.MAX_VALUE;
        quickSort(A, 0, A.length - 1);
        for (int i = 0; i < A.length - 2; i++) {
            int j = i + 1;
            int k = A.length - 1;
            while (j < k) {
                long sum = A[i] + A[j] + A[k];
                if (Math.abs(B - sum) < Math.abs(B - ansSum)) {
                    ansSum = sum;
                }
                if (sum > B) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return (int) ansSum;
    }

    private void quickSort(int[] a, int start, int end) {
        if (start < end) {
            int partition = findPartition(a, start, end);
            quickSort(a, start, partition - 1);
            quickSort(a, partition + 1, end);
        }
    }

    private int findPartition(int[] a, int start, int end) {
        int pivot = a[end];
        int pivotIndex = start;
        for (int i = start; i < end; i++) {
            if (a[i] <= pivot) {
                swap(a, i, pivotIndex);
                pivotIndex++;
            }
        }
        swap(a, end, pivotIndex);
        return pivotIndex;
    }

    private void swap(int[] arr, int i, int pivotIndex) {
        int temp = arr[i];
        arr[i] = arr[pivotIndex];
        arr[pivotIndex] = temp;
    }

    public static void main(String[] args) {
        System.out.println(
                new ThreeSum().threeSumClosest(
                        new int[]{2, 1, -9, -7, -8, 2, -8, 2, 3, -8},
                        -1
                )
        );
    }
}
