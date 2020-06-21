package com.practice.interviewbit.linkedlist;

public class ReverseLinkedList {
    public ListNode reverseBetween(ListNode head, int start, int end) {
        if (head == null || head.next == null || start == end) {
            return head;
        }
        ListNode prevNode = head;
        ListNode nextPrevNode = null;
        ListNode nextNode = head;
        ListNode dest;
        ListNode curr, next;

        while (end-- != 1) {
            prevNode = prevNode.next;
        }
        dest = prevNode;
        prevNode = prevNode.next;

        while (start-- != 1) {
            nextPrevNode = nextNode;
            nextNode = nextNode.next;
        }
        curr = nextNode;
        while (curr != dest) {
            next = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = next;
        }
        curr.next = prevNode;
        if (nextPrevNode != null) {
            nextPrevNode.next = curr;
        } else {
            head = curr;
        }

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

        ListNode ans = new ReverseLinkedList().reverseBetween(head, 5, 7);
        if (ans != null) ans.printNodes();

    }
}
