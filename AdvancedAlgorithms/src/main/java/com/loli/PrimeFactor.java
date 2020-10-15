package com.loli;

import java.util.Scanner;

public class PrimeFactor {

    public static void main(String[] args) {
        int[] arr = new int[10];

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        for (int a : arr) {
            System.out.println("Factor of " + a + " :");
            primeFactor(a);
        }
        sc.close();

    }

    private static void primeFactor(int number) {
        while (number % 2 == 0) {
            System.out.println(2);
            number /= 2;
        }
        // odd number
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                System.out.println(i);
                number = number / i;
            }
        }
        if (number > 2) {
            System.out.println(number);
        }
    }


}
