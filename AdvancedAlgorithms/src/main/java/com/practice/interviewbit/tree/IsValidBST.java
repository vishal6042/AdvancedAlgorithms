package com.practice.interviewbit.tree;

public class IsValidBST {

    public int isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
    }

    private boolean isValidBST(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }

        if (root.val < minValue || root.val > maxValue) {
            return false;
        }

        return isValidBST(root.left, minValue, root.val - 1)
                && isValidBST(root.right, root.val + 1, maxValue);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.right.right = new TreeNode(14);
        root.right.left = new TreeNode(6);
        root.right.right.left = new TreeNode(331);
        root.right.right.right = new TreeNode(40);

        System.out.println(new IsValidBST().isValidBST(root));
    }
}
