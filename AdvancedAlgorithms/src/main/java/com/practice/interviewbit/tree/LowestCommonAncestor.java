package com.practice.interviewbit.tree;

public class LowestCommonAncestor {

    public int lca(TreeNode root, int a, int b) {
        if (!find(root, a) || !find(root, b)) {
            return -1;
        }
        TreeNode lca = lcaNode(root, a, b);
        return lca == null ? -1 : lca.val;
    }

    private boolean find(TreeNode root, int a) {
        if (root == null) {
            return false;
        }
        if (root.val == a) {
            return true;
        }
        return find(root.left, a) || find(root.right, a);
    }

    private TreeNode lcaNode(TreeNode root, int a, int b) {
        if (root == null) {
            return null;
        }

        if (root.val == a || root.val == b) {
            return root;
        }

        TreeNode left = lcaNode(root.left, a, b);
        TreeNode right = lcaNode(root.right, a, b);

        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
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

        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        System.out.println(lowestCommonAncestor.lca(root, 1, 40));
        System.out.println(lowestCommonAncestor.lca(root, 11, 140));
        System.out.println(lowestCommonAncestor.lca(root, 4, 40));
    }
}
