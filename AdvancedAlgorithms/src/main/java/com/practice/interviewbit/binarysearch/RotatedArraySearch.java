package com.practice.interviewbit.binarysearch;

/**
 * https://www.interviewbit.com/problems/rotated-sorted-array-search/
 * <p>
 * Given an array of integers A of size N and an integer B.
 * <p>
 * array A is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
 * <p>
 * You are given a target value B to search. If found in the array, return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * NOTE:- Array A was sorted in non-decreasing order before rotation.
 * <p>
 * NOTE : Think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*
 * Input Format
 * <p>
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 * Output Format
 * <p>
 * Return index of B in array A, otherwise return -1
 * Constraints
 * <p>
 * 1 <= N <= 1000000
 * 1 <= A[i] <= 10^9
 * all elements in A are disitinct.
 * For Example
 * <p>
 * Input 1:
 * A = [4, 5, 6, 7, 0, 1, 2, 3]
 * B = 4
 * Output 1:
 * 0
 * Explanation 1:
 * Target 4 is found at index 0 in A.
 * <p>
 * <p>
 * Input 2:
 * A = [5, 17, 100, 3]
 * B = 6
 * Output 2:
 * -1
 */
public class RotatedArraySearch {

    public static void main(String[] args) {
        RotatedArraySearch rts = new RotatedArraySearch();
        System.out.println(rts.search(new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3}, 5));

    }

    public int search(final int[] arr, int B) {
        int pivot = findPivot(arr, 0, arr.length - 1);

        if (pivot == -1) {
            return binarySearch(arr, 0, arr.length - 1, B);
        }
        if (arr[pivot] == B) {
            return pivot;
        }
        if (arr[0] <= B) {
            return binarySearch(arr, 0, pivot - 1, B);
        } else {
            return binarySearch(arr, pivot + 1, arr.length - 1, B);
        }

    }

    private int binarySearch(int[] arr, int low, int high, int key) {
        if (high < low) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] < key) {
            return binarySearch(arr, mid + 1, high, key);
        } else {
            return binarySearch(arr, low, mid - 1, key);
        }
    }

    private int findPivot(int[] arr, int low, int high) {
        int mid = -1;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (mid < high && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid > low && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            } else if (arr[mid] > arr[low]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return mid;
    }
}
