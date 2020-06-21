package com.practice.interviewbit.linkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public void printNodes() {
        ListNode head = this;
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
