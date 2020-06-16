package com.practice.interviewbit.binarysearch;

/**
 * https://www.interviewbit.com/problems/square-root-of-integer/
 * <p>
 * Given an integar A.
 * <p>
 * Compute and return the square root of A.
 * <p>
 * If A is not a perfect square, return floor(sqrt(A)).
 * <p>
 * DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first and only argument given is the integer A.
 * Output Format
 * <p>
 * Return floor(sqrt(A))
 * Constraints
 * <p>
 * 1 <= A <= 10^9
 * For Example
 * <p>
 * Input 1:
 * A = 11
 * Output 1:
 * 3
 * <p>
 * Input 2:
 * A = 9
 * Output 2:
 * 3
 */
public class SquareRoot {
    public static void main(String[] args) {
        SquareRoot squareRoot = new SquareRoot();
        System.out.println(squareRoot.sqrt(11));
        System.out.println(squareRoot.sqrt(25));
        System.out.println(squareRoot.sqrt(255));
    }

    public int sqrt(int A) {
        if (A == 0) {
            return 0;
        }
        int low = 1;
        int high = A;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid <= A / mid) { // use A/mid instead of mid*mid because ofr integer overflow
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
