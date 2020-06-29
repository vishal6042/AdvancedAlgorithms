package com.practice.interviewbit.tree;

public class FlattenBinaryTree {

    public TreeNode flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        if (root.left != null) {
            flatten(root.left);

            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;

            TreeNode count = root.right;
            while (count.right != null) {
                count = count.right;
            }
            count.right = temp;
        }

        flatten(root.right);
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

        root = new FlattenBinaryTree().flatten(root);
        System.out.println(new InOrderTraversal().inorderTraversal(root));
    }
}
