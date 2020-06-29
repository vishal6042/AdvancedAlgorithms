package com.practice.interviewbit.tree;

public class RootToLeafPathSum {
    public int hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                return 1;
            }
        }
        return (hasPathSum(root.left, sum - root.val) == 1
                || hasPathSum(root.right, sum - root.val) == 1) ? 1 : 0;

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

        System.out.println(new RootToLeafPathSum().hasPathSum(root, 23));
    }
}
