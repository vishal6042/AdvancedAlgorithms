package com.practice.interviewbit.linkedlist;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        int finalRotate = k > length ? k % length : k;
        if (finalRotate == 0) {
            return head;
        }
        int diff = length - finalRotate;
        temp = head;
        ListNode prevTemp = null;
        while (diff-- != 0) {
            prevTemp = temp;
            temp = temp.next;
        }
        ListNode finalNode = temp;
        while (finalNode.next != null) {
            finalNode = finalNode.next;
        }

        finalNode.next = head;
        prevTemp.next = null;
        head = temp;

        return head;
    }

    public static void main(String[] args) {
        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(11);
        head2.next.next = new ListNode(15);
        head2.next.next.next = new ListNode(22);
        head2.next.next.next.next = new ListNode(23);
        head2.next.next.next.next.next = new ListNode(37);

        ListNode head = new RotateList().rotateRight(head2, 92);
        if (head != null) {
            head.printNodes();
        }

    }
}
