package com.practice.interviewbit.backtracking;

import com.practice.interviewbit.linkedlist.ListNode;

public class ReverseLinkedListUsingRecursion {

    public ListNode reverseList(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }

        ListNode temp = reverseList(A.next);
        A.next.next = A;
        A.next = null;
        return temp;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(11);
        head.next.next = new ListNode(15);
        head.next.next.next = new ListNode(22);
        head.next.next.next.next = new ListNode(23);
        head.next.next.next.next.next = new ListNode(37);
        head.next.next.next.next.next.next = new ListNode(55);

        ListNode ans = new ReverseLinkedListUsingRecursion().reverseList(head);
        if (ans != null) ans.printNodes();
    }
}
