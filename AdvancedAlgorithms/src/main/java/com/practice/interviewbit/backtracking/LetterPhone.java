package com.practice.interviewbit.backtracking;

import java.util.ArrayList;

public class LetterPhone {
    private final String arr[] = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public ArrayList<String> letterCombinations(String a) {
        if (a == null || a.isEmpty()) {
            return new ArrayList<>();
        }

        ArrayList<String> ans = new ArrayList<>();
        solve(a, ans, 0, a.length() - 1, "");
        return ans;
    }

    private void solve(String a, ArrayList<String> ans, int start, int end, String val) {
        if (val.length() == a.length()) {
            ans.add(new String(val));
        } else {
            for (int i = start; i <= end; i++) {
                String chars = arr[a.charAt(i) - '0'];
                for (int j = 0; j < chars.length(); j++) {
                    val += chars.charAt(j);
                    solve(a, ans, i + 1, end, val);
                    val = val.substring(0, val.length() - 1);
                }
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(
                new LetterPhone().letterCombinations("234")
        );
    }
}
