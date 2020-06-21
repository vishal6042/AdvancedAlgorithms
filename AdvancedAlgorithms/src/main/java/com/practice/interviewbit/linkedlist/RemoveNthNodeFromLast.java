package com.practice.interviewbit.linkedlist;

public class RemoveNthNodeFromLast {
    public ListNode removeNthFromEnd(ListNode head, int B) {
        if (head == null || B == 0) {
            return head;
        }
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        if (length <= B) {
            return head.next;
        } else {
            int diff = length - B;
            ListNode crawl = head;
            ListNode crawlPrev = null;
            while (diff-- != 0) {
                crawlPrev = crawl;
                crawl = crawl.next;
            }
            crawlPrev.next = crawl.next;
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(11);
        head2.next.next = new ListNode(15);
        head2.next.next.next = new ListNode(22);
        head2.next.next.next.next = new ListNode(23);
        head2.next.next.next.next.next = new ListNode(37);
        head2.next.next.next.next.next.next = new ListNode(44);

        ListNode head = new RemoveNthNodeFromLast().removeNthFromEnd(head2, 1);
        if (head != null) {
            head.printNodes();
        }
    }
}
