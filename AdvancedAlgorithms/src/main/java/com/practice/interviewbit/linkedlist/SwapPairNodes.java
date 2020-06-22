package com.practice.interviewbit.linkedlist;

public class SwapPairNodes {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        int count = 0;
        while (curr != null && count < 2) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if (next != null) {
            head.next = swapPairs(next);
        }
        return prev;

    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head.next;
        ListNode prev = head;
        head = curr;
        while (true) {
            ListNode next = curr.next;
            curr.next = prev;

            if (next == null || next.next == null) {
                prev.next = next;
                break;
            }
            prev.next = next.next;
            prev = next;
            curr = prev.next;

        }
        return head;

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
        head.next.next.next.next.next.next.next.next = new ListNode(28);

        ListNode ans = new SwapPairNodes().swapPairs2(head);
        if (ans != null) ans.printNodes();
    }
}
