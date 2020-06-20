package com.practice.interviewbit.twopointer;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeTwoSortedList {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(-4, -3, 0));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(2));
        new MergeTwoSortedList().merge(a, b);
        a.forEach(System.out::println);
    }

    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        if (b == null || b.size() == 0) {
            return;
        }
        if (a == null || a.size() == 0) {
            a = b;
            return;
        }
        int i = 0;
        int j = 0;
        while (i < a.size() && j < b.size()) {
            if (b.get(j) <= a.get(i)) {
                a.add(i, b.get(j));
                j++;
            }
            i++;
        }
        while (j < b.size()) {
            a.add(a.size(), b.get(j));
            j++;
        }
    }
}
