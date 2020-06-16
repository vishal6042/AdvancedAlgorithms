package com.practice.interviewbit.math;

/**
 * https://www.interviewbit.com/problems/prime-sum/
 * <p>
 * Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.
 * <p>
 * NOTE A solution will always exist. read Goldbach’s conjecture
 * <p>
 * Example:
 * <p>
 * <p>
 * Input : 4
 * Output: 2 + 2 = 4
 * <p>
 * If there are more than one solutions possible, return the lexicographically smaller solution.
 * <p>
 * If [a, b] is one solution with a <= b,
 * and [c,d] is another solution with c <= d, then
 * <p>
 * [a, b] < [c, d]
 * <p>
 * If a < c OR a==c AND b < d.
 */
public class PrimeSum {

    public static void main(String[] args) {
        PrimeSum ps = new PrimeSum();
        int arr[] = ps.primesum(4);
        System.out.println(arr[0] + " " + arr[1]);
    }

    public int[] primesum(int A) {
        if (A <= 2 || A % 2 != 0) {
            return null;
        }
        int ans[] = new int[2];
        for (int i = 2; i <= A / 2; i++) {
            if (isPrime(i) && isPrime(A - i)) {
                ans[0] = i;
                ans[1] = A - i;
                break;
            }
        }

        return ans;

    }

    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
