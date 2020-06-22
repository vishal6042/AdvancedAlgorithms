package com.practice.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (arr.size() == 1) {
            ans.add(arr);
            return ans;
        }

        permute(arr, ans, 0, arr.size() - 1);
        return ans;
    }

    private void permute(ArrayList<Integer> arr,
                         ArrayList<ArrayList<Integer>> ans,
                         int left, int right) {
        if (left == right) {
            ans.add(new ArrayList<>(arr));
        } else {
            for (int i = left; i <= right; i++) {
                int temp = arr.get(left);
                arr.set(left, arr.get(i));
                arr.set(i, temp);

                permute(arr, ans, left + 1, right);

                temp = arr.get(left);
                arr.set(left, arr.get(i));
                arr.set(i, temp);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new Permutation().permute(new ArrayList<Integer>(Arrays.asList(1, 2, 3)))
        );
    }
}
