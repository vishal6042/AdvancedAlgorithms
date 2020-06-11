package com.practice.interviewbit.arrays;

/**
 * https://www.interviewbit.com/problems/noble-integer/
 * <p>
 * Given an integer array, find if an integer p exists in the array
 * such that the number of integers greater than p in the array equals to p
 * If such an integer is found return 1 else return -1.
 */
public class NobleInteger {
    public static void main(String[] args) {
        NobleInteger nobleInteger = new NobleInteger();
        System.out.println(nobleInteger.solve(new int[]{2, 5, 3, 8, 1, 6}));
    }

    public int solve(int[] A) {
        if (A == null) {
            return -1;
        }
        if (A.length == 1) {
            return -1;
        }

        mergeSort(A, 0, A.length - 1);
        if (A[A.length - 1] == 0) {
            return 1;
        }
        for (int i = 0; i + 1 < A.length; i++) {
            if (A[i] == A[i + 1]) {
                continue;
            }
            if (A[i] + 1 == A.length - i) {
                return 1;
            }
        }


        return -1;
    }

    private void mergeSort(int[] a, int start, int end) {
        if (start != end) {
            int mid = (start + end) / 2;
            mergeSort(a, start, mid);
            mergeSort(a, mid + 1, end);
            merge(a, start, mid, end);
        }
    }

    private void merge(int[] a, int start, int mid, int end) {
        int aux[] = new int[end - start + 1];

        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (a[i] < a[j]) {
                aux[k] = a[i];
                k++;
                i++;
            } else {
                aux[k] = a[j];
                k++;
                j++;
            }
        }
        while (i <= mid) {
            aux[k++] = a[i++];
        }
        while (j <= end) {
            aux[k++] = a[j++];
        }
        for (int x = start; x <= end; x++) {
            a[x] = aux[x - start];
        }
    }
}
