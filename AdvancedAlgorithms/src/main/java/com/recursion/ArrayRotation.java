package com.recursion;

import java.util.Scanner;

public class ArrayRotation {

    /**
     * {1, 2, 3, 4, 5, 6, 7}
     * Rotate by 3
     * {4, 5, 6, 7, 1 ,2, 3}
     * <p>
     * <p>
     * STep 1:  reverse form breaking point {start, rotate point}
     * {3,2,1,4,5,6,7}
     * <p>
     * STEP 2: reverse form rotate point to end
     * {3,2,1,7,6,5,4}
     * <p>
     * STEP 3: reverse total array
     * {4,5,6,7,1,2,3}
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n < 0 || n > arr.length) {
                break;
            }
            rotateArray(arr, n);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");

            }
            System.out.println();
        }
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    private static void rotateArray(int[] arr, int n) {
        reverse(arr, 0, n - 1);
        reverse(arr, n, arr.length - 1);
        reverse(arr, 0, arr.length - 1);

    }
}
