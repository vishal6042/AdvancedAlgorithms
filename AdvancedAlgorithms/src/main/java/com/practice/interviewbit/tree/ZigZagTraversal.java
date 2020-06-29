package com.practice.interviewbit.tree;

import java.util.ArrayList;
import java.util.Stack;

public class ZigZagTraversal {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        ArrayList<Integer> row = new ArrayList<>();
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            row.clear();
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                row.add(node.val);
                if (node.left != null) {
                    stack2.push(node.left);
                }
                if (node.right != null) {
                    stack2.push(node.right);
                }
            }
            if (!row.isEmpty()) {
                ans.add(new ArrayList<>(row));
            }
            row.clear();
            while (!stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                row.add(node.val);
                if (node.right != null) {
                    stack1.push(node.right);
                }
                if (node.left != null) {
                    stack1.push(node.left);
                }
            }
            if (!row.isEmpty()) {
                ans.add(new ArrayList<>(row));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        root.left.left.left.left = new TreeNode(8);

        System.out.println(new ZigZagTraversal().zigzagLevelOrder(root));
    }
}
