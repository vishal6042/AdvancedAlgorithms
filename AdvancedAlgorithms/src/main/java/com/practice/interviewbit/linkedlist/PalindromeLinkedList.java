package com.practice.interviewbit.linkedlist;

public class PalindromeLinkedList {
    public int lPalin(ListNode head) {
        if (head == null) {
            return 0;
        }
        ListNode prev = null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && slow != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp;
        if (fast != null) {
            // odd case
            temp = reverseList(slow.next, slow);
        } else {
            // even case
            temp = reverseList(slow, prev);
        }
        ListNode start = head;
        while (start != slow) {
            if (start.val != temp.val) {
                return 0;
            }
            start = start.next;
            temp = temp.next;
        }
        return 1;
    }

    private ListNode reverseList(ListNode head, ListNode prevN) {
        ListNode curr, prev, next;
        curr = head;
        prev = prevN;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(1);

        System.out.println(new PalindromeLinkedList().lPalin(head));
    }
}
