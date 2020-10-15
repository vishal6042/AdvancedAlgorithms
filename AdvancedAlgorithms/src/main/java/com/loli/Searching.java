package com.loli;

import java.util.Scanner;

public class Searching {

    public static void main(String[] args) {

        int[] a = new int[10];
        int search, flag = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter 10 number in array");
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println("enter the element which you want to search");
        search = sc.nextInt();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == search) {
                flag = 1;
                break;
            }
        }
        if(flag==1)
            System.out.println("searching found");
        else
            System.out.println("searchin not found");
    }

}
