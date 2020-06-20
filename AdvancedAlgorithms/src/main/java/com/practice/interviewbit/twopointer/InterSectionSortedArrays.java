package com.practice.interviewbit.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterSectionSortedArrays {
    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < A.size() && j < B.size()) {
            if (A.get(i).equals(B.get(j))) {
                ans.add(A.get(i));
                i++;
                j++;
            } else if (A.get(i) < B.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(10000000 ));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(10000000 ));
        new InterSectionSortedArrays().intersect(a, b).forEach(integer -> System.out.print(integer + " "));
    }
}
