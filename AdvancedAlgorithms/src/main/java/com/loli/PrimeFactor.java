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
            System.out.print("Factor of " + a + " :");
            primeFactor(a);
            System.out.println();
        }
        sc.close();

    }

    private static void primeFactor(int number) {
        while (number % 2 == 0) {
            System.out.print(2 + " ");
            number /= 2;
        }
        // odd number
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                System.out.print(i + " ");
                number = number / i;
            }
        }
        if (number > 2) {
            System.out.print(number + " ");
        }
    }


}
