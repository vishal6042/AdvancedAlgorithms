package com.loli;

import java.util.Scanner;

public class Sorting {
    public static void main(String []args)
    {
        int a[]=new int[10];
        int i,j,temp;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the value in array");
        for(i=0;i<a.length;i++)
        {
            a[i]= sc.nextInt();
        }
        System.out.println("sorted array is");
        for(i=0;i<a.length;i++)
        {
            for (j=i+1;j<a.length;j++)
            {
                if(a[i]>a[j])
                {
                   temp=a[i];
                   a[i]=a[j];
                   a[j]=temp;
                }
            }
        }
        for (i=0;i<a.length;i++)
        {
            System.out.println(a[i]);
        }
    }
}
