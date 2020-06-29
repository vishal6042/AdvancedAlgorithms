package com.practice.interviewbit.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class OrderOfPeople {
    public ArrayList<Integer> order(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        ArrayList<Integer> C = new ArrayList<Integer>(A);
        ArrayList<Integer> D = new ArrayList<Integer>();
        Collections.sort(A);
        D.add(A.get(n - 1));
        for (int i = n - 2; i >= 0; i--) {
            int k = A.get(i);
            D.add(B.get(C.indexOf(k)), k);
        }
        return D;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(5, 3, 2, 6, 1, 4));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(0, 1, 2, 0, 3, 2));
        System.out.println(new OrderOfPeople().order(a, b));
    }
}
