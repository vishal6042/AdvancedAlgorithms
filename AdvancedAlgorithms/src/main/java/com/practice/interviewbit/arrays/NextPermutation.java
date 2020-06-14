package com.practice.interviewbit.arrays;

/**
 * https://www.interviewbit.com/problems/next-permutation/
 * <p>
 * Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.
 * <p>
 * If such arrangement is not possible, it must be rearranged as the lowest possible order i.e., sorted in an ascending order.
 * <p>
 * Note:
 * <p>
 * 1. The replacement must be in-place, do **not** allocate extra memory.
 * 2. DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.
 * Input Format:
 * <p>
 * The first and the only argument of input has an array of integers, A.
 * Output Format:
 * <p>
 * Return an array of integers, representing the next permutation of the given array.
 * Constraints:
 * <p>
 * 1 <= N <= 5e5
 * 1 <= A[i] <= 1e9
 * Examples:
 * <p>
 * Input 1:
 * A = [1, 2, 3]
 * <p>
 * Output 1:
 * [1, 3, 2]
 * <p>
 * Input 2:
 * A = [3, 2, 1]
 * <p>
 * Output 2:
 * [1, 2, 3]
 * <p>
 * Input 3:
 * A = [1, 1, 5]
 * <p>
 * Output 3:
 * [1, 5, 1]
 * <p>
 * Input 4:
 * A = [20, 50, 113]
 * <p>
 * Output 4:
 * [20, 113, 50]
 */
public class NextPermutation {

    public static void main(String[] args) {
        int a[] = new NextPermutation().nextPermutation(new int[]{20, 50, 113});
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }

    public int[] nextPermutation(int[] A) {
        if (A == null || A.length == 1) {
            return A;
        }
        int ind = -1;
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] < A[i + 1]) {
                ind = i;
                break;
            }
        }
        if (ind == -1) {
            reverse(A, 0, A.length);
            return A;
        }
        int sInd = ind + 1;
        for (int i = A.length - 1; i > ind; i--) {
            if (A[i] > A[ind]) {
                sInd = i;
                break;
            }
        }
        int temp = A[ind];
        A[ind] = A[sInd];
        A[sInd] = temp;

        reverse(A, ind + 1, A.length);
        return A;
    }

    private void reverse(int[] a, int start, int end) {
        int i = start;
        int j = end - 1;
        while (i <= j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }
}
