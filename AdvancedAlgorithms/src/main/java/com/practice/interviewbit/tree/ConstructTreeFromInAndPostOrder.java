package com.practice.interviewbit.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class ConstructTreeFromInAndPostOrder {
    static class Index {
        int index = 0;
    }

    public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postOrder) {
        if (inorder == null || postOrder == null) {
            return null;
        }
        if (inorder.size() != postOrder.size()) {
            return null;
        }
        Index index = new Index();
        index.index = postOrder.size() - 1;
        return buildTree(inorder, postOrder, 0, inorder.size() - 1, index);

    }

    private TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postOrder,
                               int start, int end, Index index) {
        if (start > end) {
            return null;
        }

        if (index.index < 0) {
            return null;
        }
        int rootVal = postOrder.get(index.index);
        TreeNode root = new TreeNode(rootVal);
        (index.index)--;
        if (start == end) {
            return root;
        }
        int pos = search(inorder, start, end, rootVal);

        root.right = buildTree(inorder, postOrder, pos + 1, end, index);
        root.left = buildTree(inorder, postOrder, start, pos - 1, index);
        return root;

    }

    private int search(ArrayList<Integer> inorder, int start, int end, int rootVal) {
        int i;
        for (i = start; i <= end; i++) {
            if (inorder.get(i) == rootVal) {
                break;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        TreeNode root = new ConstructTreeFromInAndPostOrder().buildTree(
                new ArrayList<>(Arrays.asList(9, 8, 7, 4, 2, 5, 1, 3, 6)),
                new ArrayList<>(Arrays.asList(9, 8, 7, 4, 5, 2, 6, 3, 1))
        );

        System.out.println(new InOrderTraversal().inorderTraversal(root));
        System.out.println(new PostOrderTraversal().postorderTraversal(root));
        System.out.println(new PreOrderTraversal().preorderTraversal(root));

    }
}
