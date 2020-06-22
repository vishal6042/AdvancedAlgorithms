package com.practice.interviewbit.backtracking;

import java.util.ArrayList;

public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (k == 0) {
            ans.add(new ArrayList<>());
            return ans;
        }
        if (n < k) {
            return ans;
        }
        combinationUtil(1, n, k, ans, new ArrayList<Integer>());
        return ans;
    }

    private void combinationUtil(int i, int n, int k, ArrayList<ArrayList<Integer>> ans,
                                 ArrayList<Integer> arrayList) {
        if (arrayList.size() == k) {
            ans.add(new ArrayList<>(arrayList));
            return;
        }
        for (int j = i; j <= n; j++) {
            arrayList.add(j);
            combinationUtil(j + 1, n, k, ans, arrayList);
            arrayList.remove(arrayList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(6, 3));
    }
}
