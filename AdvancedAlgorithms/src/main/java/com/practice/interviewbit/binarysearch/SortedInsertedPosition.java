package com.practice.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://www.interviewbit.com/problems/sorted-insert-position/
 * <p>
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Here are few examples.
 * <p>
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class SortedInsertedPosition {

    public static void main(String[] args) {
        SortedInsertedPosition sip = new SortedInsertedPosition();
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 3, 6, 8, 10, 25));
        System.out.println(sip.searchInsert(a, 26));
    }

    public int searchInsert(ArrayList<Integer> a, int b) {
        int low = 0;
        int high = a.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a.get(mid) == b) {
                return mid;
            } else if (a.get(mid) > b) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}
