package com.practice.interviewbit.binarysearch;

/**
 * https://www.interviewbit.com/problems/search-for-a-range/
 * <p>
 * Given a sorted array of integers A(0 based index) of size N, find the starting and ending position of a given integar B in array A.
 * <p>
 * Your algorithm’s runtime complexity must be in the order of O(log n).
 * <p>
 * Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 * Output Format
 * <p>
 * Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].
 * Constraints
 * <p>
 * 1 <= N <= 10^6
 * 1 <= A[i], B <= 10^9
 * For Example
 * <p>
 * Input 1:
 * A = [5, 7, 7, 8, 8, 10]
 * B = 8
 * Output 1:
 * [3, 4]
 * Explanation 1:
 * First occurence of 8 in A is at index 3
 * Second occurence of 8 in A is at index 4
 * ans = [3, 4]
 * <p>
 * Input 2:
 * A = [5, 17, 100, 111]
 * B = 3
 * Output 2:
 * [-1, -1]
 */
public class SearchForRange {

    public static void main(String[] args) {
        int arr[] = {5, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 10};
        int ans[] = new SearchForRange().searchRange(arr, 10);
        System.out.println(ans[0] + " " + ans[1]);
    }

    public int[] searchRange(final int[] A, int B) {
        int low = 0;
        int high = A.length - 1;
        int ans[] = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == B) {
                int lind = mid;
                int hind = mid;
                while (lind >= 0 && A[lind] == B) {
                    lind--;
                }
                while (hind <= A.length - 1 && A[hind] == B) {
                    hind++;
                }
                ans[0] = lind + 1;
                ans[1] = hind - 1;
                return ans;
            } else if (A[mid] > B) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
