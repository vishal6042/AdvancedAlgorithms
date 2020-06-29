package com.practice.interviewbit.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class InorderCartesianTree {
    public TreeNode buildTree(ArrayList<Integer> data) {
        return buildTree(data, 0, data.size() - 1);
    }

    private TreeNode buildTree(ArrayList<Integer> data, int start, int end) {
        if (start > end) {
            return null;
        }

        int index = findMax(data, start, end);
        TreeNode root = new TreeNode(data.get(index));
        if (start == end) {
            return root;
        }
        root.left = buildTree(data, start, index - 1);
        root.right = buildTree(data, index + 1, end);
        return root;
    }

    private int findMax(ArrayList<Integer> data, int start, int end) {
        int max = data.get(start);
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (max < data.get(i)) {
                max = data.get(i);
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        TreeNode root = new InorderCartesianTree().buildTree(
                new ArrayList<>(Arrays.asList(9, 8, 7, 4, 2, 5, 1, 3, 6))
        );

        System.out.println(new InOrderTraversal().inorderTraversal(root));
    }
}
