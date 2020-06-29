package com.practice.interviewbit.tree;

import java.util.ArrayList;

public class RecoverBinarySearchTree {
    TreeNode firstMismatch, lastMisMatch, middleMismatch, prevNode;

    public ArrayList<Integer> recoverTree(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        firstMismatch = middleMismatch = lastMisMatch = prevNode = null;

        recoverTreeUtil(root);
        if (firstMismatch != null && lastMisMatch != null) {

            ans.add(lastMisMatch.val);
            ans.add(firstMismatch.val);

            int data = firstMismatch.val;
            firstMismatch.val = lastMisMatch.val;
            lastMisMatch.val = data;
        } else if (firstMismatch != null && middleMismatch != null) {
            ans.add(middleMismatch.val);
            ans.add(firstMismatch.val);

            int data = firstMismatch.val;
            firstMismatch.val = middleMismatch.val;
            middleMismatch.val = data;
        }
        return ans;
    }

    private void recoverTreeUtil(TreeNode root) {

        if (root == null) {
            return;
        }
        recoverTreeUtil(root.left);

        if (prevNode != null && root.val < prevNode.val) {
            if (firstMismatch == null) {
                firstMismatch = prevNode;
                middleMismatch = root;
            } else {
                lastMisMatch = root;
            }
        }
        prevNode = root;
        recoverTreeUtil(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(14);
        root.right.right = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right.left = new TreeNode(11);
        root.right.right.right = new TreeNode(40);

        System.out.println(new RecoverBinarySearchTree().recoverTree(root));
        System.out.println(new InOrderTraversal().inorderTraversal(root));

    }
}
