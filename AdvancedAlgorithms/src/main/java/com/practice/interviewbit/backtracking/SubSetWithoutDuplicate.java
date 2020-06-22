package com.practice.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SubSetWithoutDuplicate {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (set == null) {
            return null;
        }
        Collections.sort(set);

        solve(0, set, new ArrayList<Integer>(), ans);
        return ans;
    }

    private void solve(int i, ArrayList<Integer> set, ArrayList<Integer> arrayList,
                       ArrayList<ArrayList<Integer>> ans) {
        ans.add(new ArrayList<>(arrayList));
        for (int j = i; j < set.size(); j++) {
            if (j >= 1 && set.get(j).equals(set.get(j - 1)) && j > i) {
                continue;
            }
            arrayList.add(set.get(j));
            solve(j + 1, set, arrayList, ans);
            arrayList.remove(arrayList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new SubSetWithoutDuplicate()
                        .subsetsWithDup(new ArrayList<>(Arrays.asList(1, 2, 2)))
        );
    }
}
