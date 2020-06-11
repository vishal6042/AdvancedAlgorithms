package com.practice.interviewbit.arrays;

/**
 * https://www.interviewbit.com/problems/find-duplicate-in-array/
 * <p>
 * Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.
 * <p>
 * Sample Input:
 * <p>
 * [3 4 1 4 1]
 * Sample Output:
 * <p>
 * 1
 * If there are multiple possible answers ( like in the sample case above ), output any one.
 * <p>
 * If there is no duplicate, output -1
 */
public class FindDuplicatesInArray {

    public static void main(String[] args) {
        FindDuplicatesInArray findDuplicatesInArray = new FindDuplicatesInArray();
        System.out.println(findDuplicatesInArray.repeatedNumber(new int[]{3, 4, 1, 4, 1}));
    }

    public int repeatedNumber(final int[] A) {
        if (A == null) {
            return -1;
        }
        if (A.length == 1) {
            return -1;
        }

        for (int i = 0; i < A.length; i++) {
            if (A[Math.abs(A[i]) - 1] < 0) {
                return Math.abs(A[i]);
            }
            A[Math.abs(A[i]) - 1] = -1 * A[Math.abs(A[i]) - 1];
        }
        return -1;
    }
}
