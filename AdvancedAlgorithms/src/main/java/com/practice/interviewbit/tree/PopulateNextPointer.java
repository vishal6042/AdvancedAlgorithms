package com.practice.interviewbit.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextPointer {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        TreeLinkNode temp = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode prev = temp;
                temp = queue.poll();

                if (i > 0) {
                    prev.next = temp;
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            temp.next = null;
        }

    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.right = new TreeLinkNode(6);
        root.left.left.left = new TreeLinkNode(7);
        root.left.left.left.left = new TreeLinkNode(8);
        new PopulateNextPointer().connect(root);

        System.out.println(root.left.left.next.val);
        System.out.println(root.left.next.val);


    }

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
            left = right = next = null;
        }
    }
}
