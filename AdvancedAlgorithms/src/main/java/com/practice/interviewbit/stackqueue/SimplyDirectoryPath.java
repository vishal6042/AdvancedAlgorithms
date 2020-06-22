package com.practice.interviewbit.stackqueue;

import java.util.Stack;

public class SimplyDirectoryPath {
    private final static String PREVIOUS_DIR = "..";
    private final static String CURRENT_DIR = ".";
    public static final String SEPARATOR = "/";

    public String simplifyPath(String arr) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < arr.length(); i++) {
            if (arr.charAt(i) == '/') {
                continue;
            } else {
                StringBuilder val = new StringBuilder();
                while (i < arr.length() && arr.charAt(i) != '/') {
                    val.append(arr.charAt(i));
                    i++;
                }
                if (val.toString().equals(PREVIOUS_DIR)) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (val.toString().equals(CURRENT_DIR)) {
                    continue;
                } else {
                    stack.push(val.toString());
                }
            }

        }
        if (stack.isEmpty()) {
            return SEPARATOR;
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            String val = stack.pop();
            val = new StringBuilder(val).reverse().toString();
            ans.append(val);
            ans.append(SEPARATOR);
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String dir = "/..";
        System.out.println(new SimplyDirectoryPath().simplifyPath(dir));
    }
}
