package com.practice.interviewbit.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class ConstructTreeFromInAndPreOrder {
    static class Index {
        int index = 0;
    }

    public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> preorder) {
        if (inorder == null || preorder == null) {
            return null;
        }
        if (inorder.size() != preorder.size()) {
            return null;
        }
        Index index = new Index();
        index.index = 0;
        return buildTree(inorder, preorder, 0, inorder.size() - 1, index);
    }

    private TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> preorder,
                               int start, int end, Index index) {
        if (start > end) {
            return null;
        }

//        if (index.index > end) {
//            return null;
//        }
        int rootVal = preorder.get(index.index);
        TreeNode root = new TreeNode(rootVal);
        (index.index)++;
        if (start == end) {
            return root;
        }
        int pos = search(inorder, start, end, rootVal);

        root.left = buildTree(inorder, preorder, start, pos - 1, index);
        root.right = buildTree(inorder, preorder, pos + 1, end, index);
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
        TreeNode root = new ConstructTreeFromInAndPreOrder().buildTree(
                new ArrayList<>(Arrays.asList(9, 8, 7, 4, 2, 5, 1, 3, 6)),
                new ArrayList<>(Arrays.asList(1, 2, 4, 7, 8, 9, 5, 3, 6))
        );

//        TreeNode root = new ConstructTreeFromInAndPreOrder().buildTree(
//                new ArrayList<>(Arrays.asList(2, 1, 3)),
//                new ArrayList<>(Arrays.asList(1, 2, 3))
//        );

        System.out.println(new InOrderTraversal().inorderTraversal(root));
        System.out.println(new PostOrderTraversal().postorderTraversal(root));
        System.out.println(new PreOrderTraversal().preorderTraversal(root));
    }
}
