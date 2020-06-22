package com.practice.interviewbit.stackqueue;

import java.util.Stack;

public class RedundantBraces {
    public int braces(String expression) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(') {
                stack.push(c);
            } else if (c == ')') {
                char pop = stack.peek();
                if (pop == '(') {
                    return 1;
                }
                while (stack.peek() != '(') {
                    stack.pop();
                }
                stack.pop();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(
                new RedundantBraces().braces("(a+b+(a+a+((a+b+b))))")
        );
    }
}
