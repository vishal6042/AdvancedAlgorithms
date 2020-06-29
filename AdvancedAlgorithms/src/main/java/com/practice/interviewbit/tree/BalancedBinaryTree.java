package com.practice.interviewbit.tree;

public class BalancedBinaryTree {
    static class Height {
        int height = 0;
    }

    public int isBalanced(TreeNode root) {

        return isBalanced(root, new Height()) ? 1 : 0;
    }

    private boolean isBalanced(TreeNode root, Height height) {
        if (root == null) {
            height.height = 0;
            return true;
        }

        Height left = new Height();
        Height right = new Height();

        boolean isLeft = isBalanced(root.left, left);
        boolean isRight = isBalanced(root.right, right);
        int lh = left.height;
        int rh = right.height;

        height.height = Math.max(lh, rh) + 1;
        if (Math.abs(lh - rh) >= 2) {
            return false;
        } else {
            return isLeft && isRight;
        }

    }

    public static void main(String[] args) {
        BalancedBinaryTree binaryTree = new BalancedBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        root.left.left.left.left = new TreeNode(8);
        root.left.left.left.left.left = new TreeNode(9);
        System.out.println(binaryTree.isBalanced(root));
    }
}
