package com.practice.interviewbit.twopointer;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveElementFromArray {
    public static void main(String[] args) {
        RemoveElementFromArray r = new RemoveElementFromArray();
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(2, 0, 1, 2, 0, 3, 2, 2, 2, 1, 0, 0, 0, 1));
        int elem = r.removeElement(a, 2);
        System.out.println(elem);
        System.out.println(a);
    }

    public int removeElement(ArrayList<Integer> a, int b) {
        if (a == null || a.size() < 1) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) != b) {
                a.set(index, a.get(i));
                index++;
            }
        }
        return index;
    }
}
