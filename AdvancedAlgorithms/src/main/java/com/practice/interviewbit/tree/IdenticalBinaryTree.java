package com.practice.interviewbit.tree;

public class IdenticalBinaryTree {
    public int isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return 1;
        }
        if (root1 == null || root2 == null) {
            return 0;
        }

        if (root1.val == root2.val
                && isSameTree(root1.left, root2.left) == 1
                && isSameTree(root1.right, root2.right) == 1) {
            return 1;
        }
        return 0;
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
        root.left.left.left.left.left = new TreeNode(9);

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(6);
        root1.left.left.left = new TreeNode(7);
        root1.left.left.left.left = new TreeNode(8);

        System.out.println(new IdenticalBinaryTree().isSameTree(root, root1));
    }
}
