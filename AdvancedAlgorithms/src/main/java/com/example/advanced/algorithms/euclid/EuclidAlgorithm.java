package com.example.advanced.algorithms.euclid;

/**
 * Calculates Greatest Common Divisor
 */
public class EuclidAlgorithm {

    /**
     * using recursion
     *
     * @param number
     * @param divisor
     * @return
     */
    public int gcd(int number, int divisor) {
        int remaining = (number % divisor);
        if (remaining != 0) {
            return gcd(divisor, remaining);
        }
        return divisor;
    }

    /**
     * using loops
     *
     * @param number
     * @param divisor
     * @return
     */
    public int gcd2(int number, int divisor) {
        while (divisor != 0) {
            int temp = divisor;
            divisor = number % divisor;
            number = temp;

        }
        return number;
    }
}
