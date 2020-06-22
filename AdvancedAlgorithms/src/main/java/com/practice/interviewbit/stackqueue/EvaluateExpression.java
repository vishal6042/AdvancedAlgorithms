package com.practice.interviewbit.stackqueue;

import java.util.Stack;

public class EvaluateExpression {
    public int evalRPN(String[] A) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i].equals("+")
                    || A[i].equals("-")
                    || A[i].equals("*")
                    || A[i].equals("/")) {

                int x = stack.peek();
                stack.pop();
                int y = stack.peek();
                stack.pop();

                int res = calculate(x, y, A[i]);
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(A[i]));
            }
        }
        return stack.peek();
    }

    private int calculate(int x, int y, String s) {
        if (s.equals("+")) {
            return x + y;
        } else if (s.equals("-")) {
            return y - x;
        } else if (s.equals("*")) {
            return x * y;
        } else {
            return y / x;
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new EvaluateExpression().evalRPN(
                        new String[]{"4", "13", "5", "/", "+"}
                )
        );
    }
}
