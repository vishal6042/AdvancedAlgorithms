package com.practice.interviewbit.tree;

public class InvertTheBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        root = invertTreeUtil(root);
        return root;
    }

    private TreeNode invertTreeUtil(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTreeUtil(root.left);
        TreeNode right = invertTreeUtil(root.right);
        root.left = right;
        root.right = left;
        return root;
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

        new InvertTheBinaryTree().invertTree(root);
        System.out.println(new InOrderTraversal().inorderTraversal(root));
    }
}
