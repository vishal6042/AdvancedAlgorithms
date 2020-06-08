package com.example.simple.algorithms.sorting;

public class QuickSort {
    public void doQuickSort(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int partitionIndex = findPartitionIndex(arr, start, end);
            quickSort(arr, start, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int findPartitionIndex(int[] arr, int start, int end) {
        int pivotElem = arr[end];
        int pivotIndex = start;
        for (int i = start; i <= end - 1; i++) {
            if (arr[i] <= pivotElem) {
                swap(arr, i, pivotIndex);
                pivotIndex++;
            }
        }
        swap(arr, end, pivotIndex);
        return pivotIndex;
    }

    private void swap(int[] arr, int i, int pivotIndex) {
        int temp = arr[i];
        arr[i] = arr[pivotIndex];
        arr[pivotIndex] = temp;
    }
}
