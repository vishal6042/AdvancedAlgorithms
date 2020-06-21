package com.practice.interviewbit.linkedlist;

public class ReorderList {
    public ListNode reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode firstHalf = head;
        ListNode secondHalf = slow.next;
        slow.next = null;
        secondHalf = reverseList(secondHalf);
        head = new ListNode(0);
        ListNode curr = head;
        while (firstHalf != null || secondHalf != null) {

            if (firstHalf != null) {
                curr.next = firstHalf;
                curr = curr.next;
                firstHalf = firstHalf.next;
            }
            if (secondHalf != null) {
                curr.next = secondHalf;
                curr = curr.next;
                secondHalf = secondHalf.next;
            }
        }
        head = head.next;

        return head;
    }

    private ListNode reverseList(ListNode head) {
        ListNode curr, prev = null, next;
        curr = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(11);
        head.next.next = new ListNode(15);
        head.next.next.next = new ListNode(22);
        head.next.next.next.next = new ListNode(23);
        head.next.next.next.next.next = new ListNode(37);
        head.next.next.next.next.next.next = new ListNode(55);
        head.next.next.next.next.next.next.next = new ListNode(50);

        ListNode ans = new ReorderList().reorderList(head);
        if (ans != null) ans.printNodes();
    }
}
