package com.practice.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/rotated-array/
 * <p>
 * Suppose a sorted array A is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * Find the minimum element.
 * <p>
 * The array will not contain duplicates.
 * <p>
 * NOTE 1: Also think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*
 */
public class FindMinInRotatedArray {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(4, 1, 2, 3));
        System.out.println(new FindMinInRotatedArray().findMin(arr));
    }

    public int findMin(final List<Integer> arr) {
        int mid = -1;
        int low = 0;
        int high = arr.size() - 1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (mid < high && arr.get(mid) > arr.get(mid + 1)) {
                return arr.get(mid + 1);
            } else if (mid > low && arr.get(mid) < arr.get(mid - 1)) {
                return arr.get(mid);
            } else if (arr.get(mid) > arr.get(low)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return arr.get(0);
    }
}
