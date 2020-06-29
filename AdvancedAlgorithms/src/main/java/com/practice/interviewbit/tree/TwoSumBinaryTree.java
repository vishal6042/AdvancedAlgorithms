package com.practice.interviewbit.tree;

import java.util.HashSet;
import java.util.Stack;

public class TwoSumBinaryTree {
    public int t2Sum(TreeNode root, int sum) {

        HashSet<Integer> set = new HashSet<>();
        return isSumAvailable(root, sum, set) ? 1 : 0;
    }

    public int t2Sum2(TreeNode root, int sum) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        TreeNode crawl = root;
        while (crawl != null) {
            stack1.push(crawl);
            crawl = crawl.left;
        }
        crawl = root;
        while (crawl != null) {
            stack2.push(crawl);
            crawl = crawl.right;
        }

        while (stack1.peek() != stack2.peek()) {
            int val1 = stack1.peek().val;
            int val2 = stack2.peek().val;

            if (val1 + val2 == sum) {
                return 1;
            } else if (val1 + val2 < sum) {
                crawl = stack1.peek().right;
                stack1.pop();
                while (crawl != null) {
                    stack1.push(crawl);
                    crawl = crawl.left;
                }
            } else {
                crawl = stack2.peek().left;
                stack2.pop();
                while (crawl != null) {
                    stack2.push(crawl);
                    crawl = crawl.right;
                }
            }
        }
        return 0;

    }

    private boolean isSumAvailable(TreeNode root, int sum, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }
        if (isSumAvailable(root.left, sum, set)) {
            return true;
        }

        if (set.contains(sum - root.val)) {
            return true;
        } else {
            set.add(root.val);
        }
        return isSumAvailable(root.right, sum, set);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.right.right = new TreeNode(14);
        root.right.left = new TreeNode(6);
        root.right.right.left = new TreeNode(11);
        root.right.right.right = new TreeNode(40);

        System.out.println(new TwoSumBinaryTree().t2Sum2(root, 12));
    }
}
