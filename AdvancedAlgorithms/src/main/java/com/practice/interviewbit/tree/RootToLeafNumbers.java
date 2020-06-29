package com.practice.interviewbit.tree;

import java.math.BigInteger;
import java.util.ArrayList;

public class RootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        ArrayList<String> numbers = new ArrayList<>();
        solve(root, numbers, "");
        //System.out.println(numbers);
        BigInteger mod = new BigInteger("1003");
        long sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            BigInteger bigInteger = new BigInteger(numbers.get(i));
            bigInteger = bigInteger.mod(mod);
            sum = (sum  + (Long.parseLong(bigInteger.toString())) % 1003) % 1003;
        }
        return (int) sum;
    }

    private void solve(TreeNode root, ArrayList<String> numbers, String s) {
        if (root == null || root.val == -1) {
            return;
        }

        if (root.left == null && root.right == null) {
            s += root.val;
            numbers.add(new String(s));
            s = s.substring(0, s.length() - 1);
        }
        s += root.val;
        solve(root.left, numbers, s);
        solve(root.right, numbers, s);
        s = s.substring(0, s.length() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(new RootToLeafNumbers().sumNumbers(root));
    }
}
