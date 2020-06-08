package com.practice.interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
 * <p>
 * Find the contiguous subarray within an array, A of length N which has the largest sum.
 * <p>
 * Input Format:
 * <p>
 * The first and the only argument contains an integer array, A.
 * Output Format:
 * <p>
 * Return an integer representing the maximum possible sum of the contiguous subarray.
 * Constraints:
 * <p>
 * 1 <= N <= 1e6
 * -1000 <= A[i] <= 1000
 * For example:
 * <p>
 * Input 1:
 * A = [1, 2, 3, 4, -10]
 * <p>
 * Output 1:
 * 10
 * <p>
 * Explanation 1:
 * The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
 * <p>
 * Input 2:
 * A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 * <p>
 * Output 2:
 * 6
 * <p>
 * Explanation 2:
 * The subarray [4,-1,2,1] has the maximum possible sum of 6.
 */
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
