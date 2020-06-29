package com.practice.interviewbit.tree;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        stack.push(curr);

        while (!stack.isEmpty()) {
            curr = stack.pop();
            ans.add(curr.val);

            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
        return ans;
    }
}
