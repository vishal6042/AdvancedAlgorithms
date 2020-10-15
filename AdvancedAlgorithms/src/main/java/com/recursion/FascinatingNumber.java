package com.recursion;

import java.util.Arrays;

public class FascinatingNumber {
    public static void main(String[] args) {
        FascinatingNumber fn = new FascinatingNumber();
        System.out.println(fn.isFascinatingNumber(3452345));
    }

    public boolean isFascinatingNumber(int n) {
        int noOfDigit = countDigit(n);
        System.out.println("No of Digit is " + noOfDigit);
        if (noOfDigit < 3) {
            return false;
        }
        int mul2 = n * 2;
        int mul3 = n * 3;
        char arr[] = concatenate(n, mul2, mul3);
        if (arr.length != 9) {
            return false;
        }
        System.out.println(new String(arr));

        return allDigitOnlyOnceOccured(arr);
    }

    public char[] concatenate(int... a) {
        int size = a.length;
        char arr[] = new char[1000];
        int index = 0;
        for (int i = 0; i < size; i++) {
            int num = a[i];

            while (num > 0) {
                int rem = num % 10;
                num = num / 10;
                arr[index++] = (char) (rem + '0');
            }
        }

        char[] result = new char[index];
        for (int i = 0; i < index; i++) {
            result[i] = arr[i];
        }
        return result;

    }

    public boolean allDigitOnlyOnceOccured(char[] arr) {
        int digit[] = new int[10];
        Arrays.fill(digit, 0);

        for (char c : arr) {
            digit[c - '0']++;
            if (digit[c - '0'] > 1) {
                return false;
            }
        }

        for (int i = 1; i < 10; i++) {
            if (digit[i] != 1) {
                return false;
            }
        }
        return true;
    }

    public int countDigit(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n /= 10;
        }
        return count;
    }
}
