package com.practice.interviewbit.tree;

public class SymmetricalTree {
    public int isSymmetric(TreeNode root) {
        return isSymmetric(root, root) ? 1 : 0;
    }

    private boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        return root1.val == root2.val && isSymmetric(root1.left, root2.right)
                && isSymmetric(root1.right, root2.left);
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
        System.out.println(new SymmetricalTree().isSymmetric(root));
    }
}
