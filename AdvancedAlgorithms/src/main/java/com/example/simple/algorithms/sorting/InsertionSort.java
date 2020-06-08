package com.example.simple.algorithms.sorting;

public class InsertionSort {
    public void doInsertionSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int n = arr.length;
        if (n == 1) {
            return;
        }
        for (int i = 1; i < n; ++i) {
            int val = arr[i];
            int index = i - 1;

            while (index >= 0 && val < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = val;
        }
    }
}
