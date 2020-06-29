package com.practice.interviewbit.tree;

public class KthSmallestInBinarySearchTree {
    int count = 0;

    public int kthsmallest(TreeNode root, int k) {
        TreeNode kth = kthsmallestNode(root, k);
        return kth.val;
    }

    private TreeNode kthsmallestNode(TreeNode root, int k) {
        if (root == null) {
            return null;
        }

        TreeNode left = kthsmallestNode(root.left, k);
        if (left != null) {
            return left;
        }
        count++;
        if (count == k) {
            return root;
        }
        return kthsmallestNode(root.right, k);
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

        for (int i = 1; i <= 8; i++) {
            System.out.println(new KthSmallestInBinarySearchTree().kthsmallest(root, i));
        }

    }
}
