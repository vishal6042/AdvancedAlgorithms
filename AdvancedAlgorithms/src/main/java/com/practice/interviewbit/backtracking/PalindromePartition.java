package com.practice.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class PalindromePartition {
    public ArrayList<ArrayList<String>> partition(String arr) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        if (arr == null || arr.length() == 0) {
            return ans;
        }
        if (arr.length() == 1) {
            ans.add(new ArrayList<String>(Arrays.asList(arr)));
            return ans;
        }

        solve(arr, 0, arr.length(), new ArrayList<String>(), ans);
        return ans;
    }

    private void solve(String arr, int start, int end,
                       ArrayList<String> strings, ArrayList<ArrayList<String>> ans) {

        if (start >= end) {
            ans.add(new ArrayList<>(strings));
            return;
        }
        for (int i = start; i < end; i++) {
           // System.out.println(start + " " + i);
            String subs = arr.substring(start, i + 1);
            if (isPalindrome(subs)) {
                strings.add(subs);
                solve(arr, i + 1, end, strings, ans);
                strings.remove(strings.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String subs) {
        return subs.equals(new StringBuilder(subs).reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(
                new PalindromePartition().partition("abb")
        );
    }
}
