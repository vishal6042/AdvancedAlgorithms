package com.practice.interviewbit.linkedlist;

public class MergeSortInList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMiddle(head);
        ListNode midPlusOne = mid.next;
        mid.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(midPlusOne);

        ListNode merged = mergeList(left, right);
        return merged;
    }

    private ListNode mergeList(ListNode left, ListNode right) {
        ListNode result = null;
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        if (left.val <= right.val) {
            result = left;
            result.next = mergeList(left.next, right);
        } else {
            result = right;
            result.next = mergeList(left, right.next);
        }
        return result;
    }

    private ListNode getMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(31);
        head.next.next = new ListNode(15);
        head.next.next.next = new ListNode(22);
        head.next.next.next.next = new ListNode(23);
        head.next.next.next.next.next = new ListNode(12);
        head.next.next.next.next.next.next = new ListNode(55);
        head.next.next.next.next.next.next.next = new ListNode(20);

        ListNode ans = new MergeSortInList().sortList(head);
        if (ans != null) ans.printNodes();
    }
}
