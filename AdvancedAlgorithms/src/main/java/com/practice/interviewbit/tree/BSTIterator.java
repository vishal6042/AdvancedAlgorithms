package com.practice.interviewbit.tree;

import java.util.Stack;

public class BSTIterator {
    private Stack<TreeNode> stack = null;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode crawl = root;
        while (crawl != null) {
            stack.push(crawl);
            crawl = crawl.left;
        }

    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if (stack.isEmpty()) {
            return -1;
        }
        int val = stack.peek().val;
        TreeNode next = stack.peek().right;
        stack.pop();
        while (next != null) {
            stack.push(next);
            next = next.left;
        }
        return val;
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

        BSTIterator bstIterator = new BSTIterator(root);
        while (bstIterator.hasNext()) {
            System.out.println(bstIterator.next());
        }
    }
}
