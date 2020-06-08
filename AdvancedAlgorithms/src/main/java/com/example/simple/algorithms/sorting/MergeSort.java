package com.example.simple.algorithms.sorting;

public class MergeSort {
    public void doMergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);

    }

    private void mergeSort(int[] arr, int start, int end) {
        if (start != end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int aux[] = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                aux[k++] = arr[i];
                i++;
            } else {
                aux[k++] = arr[j];
                j++;
            }
        }
        while (i <= mid) {
            aux[k++] = arr[i++];
        }
        while (j <= end) {
            aux[k++] = arr[j++];
        }

        for (int x = start; x <= end; x++) {
            arr[x] = aux[x - start];
        }
    }
}
