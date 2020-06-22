package com.practice.interviewbit.linkedlist;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {

        ListNode smallXHead = null;
        ListNode smallXTail = null;
        ListNode bigXHead = null;
        ListNode bigXTail = null;

        ListNode crawl = head;
        while (crawl != null) {
            if (crawl.val < x) {
                if (smallXHead == null) {
                    smallXHead = smallXTail = crawl;
                } else {
                    smallXTail.next = crawl;
                    smallXTail = smallXTail.next;
                }
            } else {
                if (bigXHead == null) {
                    bigXHead = bigXTail = crawl;
                } else {
                    bigXTail.next = crawl;
                    bigXTail = crawl;
                }
            }
            crawl = crawl.next;
        }

        if (bigXTail != null) {
            bigXTail.next = null;
        }
        if (smallXHead == null) {
            return bigXHead;
        }
        smallXTail.next = bigXHead;
        return smallXHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(31);
        head.next.next = new ListNode(15);
        head.next.next.next = new ListNode(22);
        head.next.next.next.next = new ListNode(23);
        head.next.next.next.next.next = new ListNode(22);
        head.next.next.next.next.next.next = new ListNode(55);
        head.next.next.next.next.next.next.next = new ListNode(50);

        ListNode ans = new PartitionList().partition(head, 22);
        if (ans != null) ans.printNodes();
    }
}
