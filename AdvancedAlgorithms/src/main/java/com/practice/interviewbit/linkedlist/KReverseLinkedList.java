package com.practice.interviewbit.linkedlist;

public class KReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(31);
        head.next.next = new ListNode(15);
        head.next.next.next = new ListNode(22);
        head.next.next.next.next = new ListNode(23);
        head.next.next.next.next.next = new ListNode(12);
        head.next.next.next.next.next.next = new ListNode(55);
        head.next.next.next.next.next.next.next = new ListNode(20);
        head.next.next.next.next.next.next.next.next = new ListNode(28);

        ListNode ans = new KReverseLinkedList().reverseList(head, 3);
        if (ans != null) ans.printNodes();
    }

    public ListNode reverseList(ListNode head, int k) {

        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        int count = 0;
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if (next != null) {
            head.next = reverseList(next, k);
        }
        return prev;
    }
}
