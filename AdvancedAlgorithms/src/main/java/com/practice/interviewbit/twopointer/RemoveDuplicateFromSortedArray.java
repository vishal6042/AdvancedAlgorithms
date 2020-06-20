package com.practice.interviewbit.twopointer;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicateFromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicateFromSortedArray r = new RemoveDuplicateFromSortedArray();
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 3, 3, 3, 4, 5, 6, 6, 6, 6));
        r.removeDuplicates(a);
        System.out.println(a);

    }

    public int removeDuplicates1(ArrayList<Integer> a) {
        if (a == null || a.size() < 1) {
            return 0;
        }
        if (a.size() == 1) {
            return 1;
        }
        int curr = 0;
        for (int i = 1; i < a.size(); i++) {
            if (!a.get(i).equals(a.get(curr))) {
                a.set(++curr, a.get(i));
            }
        }
        return curr + 1;
    }

    public int removeDuplicates(ArrayList<Integer> a) {
        if (a == null || a.size() < 1) {
            return 0;
        }
        if (a.size() <= 2) {
            return a.size();
        }
        int index = 2;
        for (int i = 2; i < a.size(); ) {
            if (!a.get(i).equals(a.get(index - 1)) || !a.get(i).equals(a.get(index - 2))) {
                a.set(index, a.get(i));
                index++;
            }
            i++;
        }
        return index;
    }
}
