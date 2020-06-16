package com.practice.interviewbit.math;

import java.util.ArrayList;

public class ReArrangeArrays {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(2);
        new ReArrangeArrays().arrange(arrayList);
        System.out.println(arrayList);
    }

    public void arrange(ArrayList<Integer> a) {
        arrange(a, 0);
    }

    private void arrange(ArrayList<Integer> a, int i) {
        if (i == a.size()) {
            return;
        }
        int curr = a.get(a.get(i));
        arrange(a, i + 1);
        a.set(i, curr);
    }
}
