package com.practice.interviewbit.twopointer;

public class CountingTriangles {

    public int nTriang(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }

        mergeSort(A, 0, A.length - 1);
        int mod = 1000000007;
        int res = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            int j = 0;
            int k = i - 1;

            while (j < k) {
                long sum = (A[j] + A[k]);
                if (A[i] < sum) {
                    res = (res + (k - j) % mod) % mod;
                    k--;
                } else {
                    j++;
                }

            }
        }
        return res;
    }

    private void mergeSort(int[] a, int start, int end) {
        if (start != end) {
            int mid = start + (end - start) / 2;
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
            if (a[i] <= a[j]) {
                aux[k++] = a[i++];
            } else {
                aux[k++] = a[j++];
            }
        }
        while (i <= mid) {
            aux[k++] = a[i++];
        }
        while (j <= end) {
            aux[k++] = a[j++];
        }

        for (int l = start; l <= end; l++) {
            a[l] = aux[l - start];
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new CountingTriangles().nTriang(
                        new int[]{1, 2, 1, 2, 1}
                )
        );
    }

}
