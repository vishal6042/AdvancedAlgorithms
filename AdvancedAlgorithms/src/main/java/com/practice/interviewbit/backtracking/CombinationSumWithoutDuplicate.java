package com.practice.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationSumWithoutDuplicate {

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> data, int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (data.size() == 0) {
            return ans;
        }
        if (data.size() == 1 && data.get(0) == sum) {
            ans.add(data);
            return ans;
        }
        Collections.sort(data);
        solve(0, sum, data, new ArrayList<Integer>(), ans);
        return ans;
    }

    private void solve(int i, int sum, ArrayList<Integer> data,
                       ArrayList<Integer> arrayList, ArrayList<ArrayList<Integer>> ans) {
        if (sum < 0) {
            return;
        }
        if (sum == 0) {
            ans.add(new ArrayList<>(arrayList));
            return;
        }
        for (int j = i; j < data.size(); j++) {
            if (sum - data.get(j) >= 0) {
                if (j >= 1 && data.get(j).equals(data.get(j - 1)) && j > i) {
                    continue;
                }
                arrayList.add(data.get(j));
                solve(j + 1, sum - data.get(j), data, arrayList, ans);
                arrayList.remove(arrayList.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(
                new CombinationSumWithoutDuplicate().combinationSum(
                        new ArrayList<>(Arrays.asList(1, 1, 2, 3, 2, 1)),
                        5
                )
        );
    }
}
