package com.practice.interviewbit.linkedlist;

public class Subtract {
    public ListNode subtract(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode slowPrev = null;
        while (fast != null && fast.next != null) {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slowPrev = slow;
            slow = slow.next;
        }
        ListNode secondHalf = slow;
        ListNode reverse = reverse(secondHalf);
        slowPrev.next = null;
        slow = head;
        ListNode temp = reverse;
        while (slow != null && temp != null) {
            slow.val = temp.val - slow.val;
            slow = slow.next;
            temp = temp.next;
        }
        reverse = reverse(reverse);
        slowPrev.next = reverse;

        return head;
    }

    private ListNode reverse(ListNode secondHalf) {
        ListNode curr = secondHalf;
        ListNode prev = null;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(11);
        head.next.next = new ListNode(15);
//        head.next.next.next = new ListNode(22);
//        head.next.next.next.next = new ListNode(23);
//        head.next.next.next.next.next = new ListNode(37);
//        head.next.next.next.next.next.next = new ListNode(55);
        //head.next.next.next.next.next.next.next = new ListNode(50);

        ListNode ans = new Subtract().subtract(head);
        if (ans != null) ans.printNodes();
    }

}
