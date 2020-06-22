package com.practice.interviewbit.linkedlist;

public class InsertionSortInList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode index = head;
        ListNode sorted = null;
        while (index != null) {
            ListNode next = index.next;
            sorted = insertList(sorted, index);
            index = next;
        }
        head = sorted;
        return head;
    }

    private ListNode insertList(ListNode sorted, ListNode index) {
        if (sorted == null || index.val <= sorted.val) {
            index.next = sorted;
            sorted = index;
        } else {
            ListNode temp = sorted;
            while (temp.next != null && temp.next.val < index.val) {
                temp = temp.next;
            }
            index.next = temp.next;
            temp.next = index;

        }
        return sorted;
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

        ListNode ans = new InsertionSortInList().insertionSortList(head);
        if (ans != null) ans.printNodes();
    }
}
