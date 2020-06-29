package com.practice.interviewbit.tree;

import java.util.ArrayList;

public class RootToLeafPathSumNodes {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        solve(root, sum, ans, new ArrayList<Integer>());
        return ans;
    }

    private boolean solve(TreeNode root, int sum, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> path) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            path.add(root.val);
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return true;
        }
        path.add(root.val);
        solve(root.left, sum - root.val, ans, path);
        solve(root.right, sum - root.val, ans, path);
        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left = new TreeNode(13);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(new RootToLeafPathSumNodes().pathSum(root, 22));
    }
}
