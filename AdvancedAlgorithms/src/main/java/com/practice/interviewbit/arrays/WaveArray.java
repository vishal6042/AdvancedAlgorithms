package com.practice.interviewbit.arrays;

import java.util.Arrays;

/**
 * https://www.interviewbit.com/problems/wave-array/
 * <p>
 * Given an array of integers, sort the array into a wave like array and return it,
 * In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....
 * <p>
 * Example
 * <p>
 * Given [1, 2, 3, 4]
 * <p>
 * One possible answer : [2, 1, 4, 3]
 * Another possible answer : [4, 1, 3, 2]
 * NOTE : If there are multiple answers possible, return the one thats lexicographically smallest.
 * So, in example case, you will return [2, 1, 4, 3]
 */
public class WaveArray {

    public static void main(String[] args) {
        int a[] = new WaveArray().wave(new int[]{5, 1, 3, 2, 4});
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public int[] wave(int[] A) {
        Arrays.sort(A);
        boolean flag = false;

        for (int i = 1; i < A.length; i++) {
            if (flag) {
                if (A[i] < A[i - 1]) {
                    int temp = A[i];
                    A[i] = A[i - 1];
                    A[i - 1] = temp;
                }
            } else {
                if (A[i] > A[i - 1]) {
                    int temp = A[i];
                    A[i] = A[i - 1];
                    A[i - 1] = temp;
                }

            }
            flag = !flag;
        }
        return A;
    }
}
