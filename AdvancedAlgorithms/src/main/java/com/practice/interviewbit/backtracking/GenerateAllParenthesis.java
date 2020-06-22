package com.practice.interviewbit.backtracking;

import java.util.ArrayList;

public class GenerateAllParenthesis {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }

        solve(n, 0, 0, ans, "");
        return ans;
    }

    private void solve(int n, int openCount, int closeCount, ArrayList<String> ans, String s) {

        if (openCount == n && closeCount == n) {
            ans.add(s);
            return;
        } else {
            if (openCount < n) {
                s += "(";
                solve(n, openCount + 1, closeCount, ans, s);
                s = s.substring(0, s.length() - 1);
            }
            if (openCount > closeCount) {
                s += ")";
                solve(n, openCount, closeCount + 1, ans, s);
                s = s.substring(0, s.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateAllParenthesis().generateParenthesis(3));
    }
}
