package com.practice.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Subset {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (set == null) {
            return null;
        }
        Collections.sort(set);
        ans.add(new ArrayList<>());

        for (int i = 0; i < set.size(); i++) {
            subsetsUtil(set, ans, new ArrayList<Integer>(), i);
        }
        return ans;
    }

    private void subsetsUtil(ArrayList<Integer> set, ArrayList<ArrayList<Integer>> ans,
                             ArrayList<Integer> temp, int i) {
        temp.add(set.get(i));
        ans.add(temp);
        if (i == set.size()) {
            return;
        }
        for (int j = i + 1; j < set.size(); j++) {
            subsetsUtil(set, ans, new ArrayList<Integer>(temp), j);
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new Subset().subsets(new ArrayList<>(Arrays.asList(2, 4, 6, 5)))
        );
    }
}
