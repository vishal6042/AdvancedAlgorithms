package com.practice.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (A.size() == 0) {
            return ans;
        }
        if (A.size() == 1 && A.get(0) == B) {
            ans.add(A);
            return ans;
        }

        Collections.sort(A);
        A = (ArrayList<Integer>) A.stream().distinct().collect(Collectors.toList());

        solve(0, B, new ArrayList<Integer>(), ans, A);

        return ans;
    }

    private void solve(int i, int sum, ArrayList<Integer> arrayList,
                       ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> data) {
        if (sum < 0) {
            return;
        }

        if (sum == 0) {
            ans.add(new ArrayList<>(arrayList));
            return;
        }

        for (int j = i; j < data.size(); ) {
            if (sum - data.get(j) >= 0) {
                arrayList.add(data.get(j));
                solve(j, sum - data.get(j), arrayList, ans, data);
                arrayList.remove(arrayList.size() - 1);
            }
            j++;
        }

    }

    public static void main(String[] args) {
        System.out.println(
                new CombinationSum().combinationSum(
                        new ArrayList<>(Arrays.asList(1, 1, 7, 1, 4, 1, 4, 1, 3, 1, 2, 1, 7, 1, 2, 1, 9)),
                        5
                )
        );
    }
}
