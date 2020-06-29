package com.practice.interviewbit.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedArrayToBalancedBST {
    public TreeNode sortedArrayToBST(final List arr) {
        return sortedArrayToBST(arr, 0, arr.size() - 1);
    }

    private TreeNode sortedArrayToBST(List<Integer> arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(arr.get(mid));
        if (start == end) {
            return root;
        }
        root.left = sortedArrayToBST(arr, start, mid - 1);
        root.right = sortedArrayToBST(arr, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new SortedArrayToBalancedBST().sortedArrayToBST(
                new ArrayList(Arrays.asList(1,2,3,4,5,6))
        );

        System.out.println(new InOrderTraversal().inorderTraversal(root));
    }
}
