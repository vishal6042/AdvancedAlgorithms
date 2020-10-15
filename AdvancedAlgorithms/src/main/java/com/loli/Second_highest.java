package com.loli;

import java.util.Scanner;

public class Second_highest {
    public static void main(String []args)
    {
        int a[]=new int[10];
        int gt,sgt,i;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter element in array");
        for (i=0;i<a.length;i++)
        {
            a[i]=sc.nextInt();
        }
        gt=a[0];
        //sgt=0;
        sgt=-998888787;
        for (i=1;i<a.length;i++)
        {
            if(a[i]>gt) {
                sgt = gt;
                gt = a[i];

            }
            else if(a[i]>sgt)
            {
                sgt=a[i];
            }
        }
        System.out.println("second largest="+sgt);
    }
}
