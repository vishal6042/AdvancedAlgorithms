package com.practice.interviewbit.linkedlist;

public class RemoveDuplicateFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = first.next;

        while (second != null) {
            if (first.val == second.val) {
                ListNode temp = second.next;
                first.next = temp;
                second = temp;
            } else {
                first = second;
                second = second.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next = new ListNode(5);

        new RemoveDuplicateFromSortedList().deleteDuplicates(head).printNodes();
    }
}
