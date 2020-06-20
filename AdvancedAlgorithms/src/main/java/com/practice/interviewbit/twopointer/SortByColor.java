package com.practice.interviewbit.twopointer;

import java.util.ArrayList;
import java.util.Arrays;

public class SortByColor {

    public void sortColors(ArrayList<Integer> a) {
        int low = 0;
        int mid = 0;
        int high = a.size() - 1;

        while (mid <= high) {
            if (a.get(mid) == 0) {
                int t = a.get(mid);
                a.set(mid, a.get(low));
                a.set(low, t);
                mid++;
                low++;
            } else if (a.get(mid) == 2) {
                int t = a.get(mid);
                a.set(mid, a.get(high));
                a.set(high, t);
                high--;
            } else {
                mid++;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1));
        new SortByColor().sortColors(arrayList);
        System.out.println(arrayList);
    }
}
