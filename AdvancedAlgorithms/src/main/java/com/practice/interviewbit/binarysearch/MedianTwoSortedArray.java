package com.practice.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianTwoSortedArray {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 3, 8, 9, 15));
        List<Integer> b = new ArrayList<>(Arrays.asList(7, 11, 18, 19, 21, 25));
        System.out.println(new MedianTwoSortedArray().findMedianSortedArrays(a, b));
    }

    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        if (a.size() > b.size()) {
            return findMedianSortedArrays(b, a);
        }
        boolean isEven = (a.size() + b.size()) % 2 == 0;

        int low = 0;
        int high = a.size();
        int partitionX;
        int partitionY;
        double ans = 0;
        while (low <= high) {
            partitionX = low + (high - low) / 2;
            partitionY = (a.size() + b.size() + 1) / 2 - partitionX;

            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : a.get(partitionX - 1);
            int minRightX = partitionX == a.size() ? Integer.MAX_VALUE : a.get(partitionX);

            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : b.get(partitionY - 1);
            int minRightY = partitionY == b.size() ? Integer.MAX_VALUE : b.get(partitionY);


            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if (isEven) {
                    ans = (double) (Math.max(maxLeftX, maxLeftY) +
                            Math.min(minRightX, minRightY)) / 2;
                } else {
                    ans = (double) Math.max(maxLeftX, maxLeftY);
                }
                return ans;
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;

            } else {
                low = partitionX + 1;
            }
        }
        return ans;

    }


}
