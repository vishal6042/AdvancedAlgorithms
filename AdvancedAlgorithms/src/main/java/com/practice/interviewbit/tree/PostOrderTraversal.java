package com.practice.interviewbit.tree;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (true) {
            while (curr != null) {
                stack.push(curr);
                stack.push(curr);
                curr = curr.left;
            }
            if (stack.isEmpty()) {
                return ans;
            }
            curr = stack.pop();
            if (!stack.isEmpty() && stack.peek() == curr) {
                curr = curr.right;
            } else {
                ans.add(curr.val);
                curr = null;
            }
        }
    }
}
