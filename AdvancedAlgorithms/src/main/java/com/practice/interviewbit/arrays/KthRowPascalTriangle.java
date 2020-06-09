package com.practice.interviewbit.arrays;

/**
 * https://www.interviewbit.com/problems/kth-row-of-pascals-triangle/
 * <p>
 * Given an index k, return the kth row of the Pascal’s triangle.
 * <p>
 * Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.
 * <p>
 * Example:
 * <p>
 * Input : k = 3
 * <p>
 * Return : [1,3,3,1]
 * NOTE : k is 0 based. k = 0, corresponds to the row [1].
 * Note:Could you optimize your algorithm to use only O(k) extra space?
 */
public class KthRowPascalTriangle {

    public static void main(String[] args) {
        int arr[] = new KthRowPascalTriangle().getRow(0);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public int[] getRow(int A) {
        int n = A + 1;
        int ans[] = new int[n];
        int c = 1;
        int index = 0;
        for (int i = 1; i <= n; i++) {
            ans[index++] = c;
            c = c * (n - i) / i;
        }

        return ans;
    }
}
