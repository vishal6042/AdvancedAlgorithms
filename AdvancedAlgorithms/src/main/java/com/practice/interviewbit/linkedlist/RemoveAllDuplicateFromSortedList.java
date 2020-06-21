package com.practice.interviewbit.linkedlist;

public class RemoveAllDuplicateFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode firstPrev = null;
        ListNode second = first.next;
        while (first != null && second != null) {
            if (first.val == second.val) {
                while (second != null && second.val == first.val) {
                    second = second.next;
                }
                if (firstPrev != null) {
                    firstPrev.next = second;
                } else {
                    head = second;
                }
                first = second;
                if (second != null) {
                    second = second.next;
                }

            } else {
                firstPrev = first;
                first = first.next;
                second = second.next;

            }
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next = new ListNode(4);

        new RemoveAllDuplicateFromSortedList().deleteDuplicates(head).printNodes();
    }
}
