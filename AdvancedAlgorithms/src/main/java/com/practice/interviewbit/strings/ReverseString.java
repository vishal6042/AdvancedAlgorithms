package com.practice.interviewbit.strings;

public class ReverseString {
    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.solve("      yvgdsy alydvgal    iuasgv a sudvghisauv oui;shguv    "));
    }

    public String solve(String A) {
        if (A == null || A.isEmpty()) {
            return "";
        }
        A = A.trim();
        String arr[] = A.split("[\\s]");
        StringBuilder ans = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            String start = arr[i].trim();
            if (!start.isEmpty()) {
                ans.append(start);
                if (i > 0) {
                    ans.append(" ");
                }
            }

        }
        return ans.toString();
    }
}
