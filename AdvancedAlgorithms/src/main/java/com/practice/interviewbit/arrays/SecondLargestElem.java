package com.practice.interviewbit.arrays;

public class SecondLargestElem {

    public static void main(String[] args) {
        System.out.println(new SecondLargestElem().secondLargest(
                new int[]{1, 1, 5, 12, 18, 13, 19, 14, 7}
        ));
    }

    public int secondLargest(int arr[]) {
        int largest = Integer.MIN_VALUE;
        int slargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (largest < arr[i]) {
                slargest = largest;
                largest = arr[i];
            } else if (arr[i] > slargest) {
                slargest = arr[i];
            }
        }
        return slargest;
    }
}
