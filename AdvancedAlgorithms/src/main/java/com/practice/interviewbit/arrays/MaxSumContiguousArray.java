package com.practice.interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

public class MaxSumContiguousArray {
    public static void main(String[] args) {
        MaxSumContiguousArray maxSumContiguousArray = new MaxSumContiguousArray();
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(-1);
        arrayList.add(-2);
        arrayList.add(-4);
        arrayList.add(-9);
        System.out.println(maxSumContiguousArray.maxSubArray(arrayList));
    }

    public int maxSubArray(final List<Integer> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return -1;
        }
        if (allNeg(arrayList)) {
            return largest(arrayList);
        }
        int maxSoFar = 0;
        int maxEndHere = 0;


        for (int i = 0; i < arrayList.size(); i++) {
            maxEndHere += arrayList.get(i);
            if (maxEndHere < 0) {
                maxEndHere = 0;
            } else if (maxSoFar < maxEndHere) {
                maxSoFar = maxEndHere;
            }
        }
        return maxSoFar;
    }

    private int largest(List<Integer> arrayList) {
        int ans = arrayList.get(0);
        for (int i = 1; i < arrayList.size(); i++) {
            if (ans < arrayList.get(i)) {
                ans = arrayList.get(i);
            }
        }
        return ans;
    }

    private boolean allNeg(List<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) > 0) {
                return false;
            }
        }
        return true;
    }
}
