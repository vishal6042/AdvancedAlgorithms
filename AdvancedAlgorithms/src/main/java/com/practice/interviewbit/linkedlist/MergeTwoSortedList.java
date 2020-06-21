package com.practice.interviewbit.linkedlist;

public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode head3 = null;
        ListNode first = head1;
        ListNode second = head2;
        ListNode tempHead3 = head3;

        while (first != null && second != null) {
            if (first.val <= second.val) {
                tempHead3 = insertNode(tempHead3, first.val);
                first = first.next;
            } else {
                tempHead3 = insertNode(tempHead3, second.val);
                second = second.next;
            }
            if (head3 == null) {
                head3 = tempHead3;
            }


        }
        if (first != null) {
            tempHead3.next = first;
        }
        if (second != null) {
            tempHead3.next = second;
        }
        return head3;
    }

    private ListNode insertNode(ListNode head3, int val) {
        if (head3 == null) {
            head3 = new ListNode(val);
            return head3;
        } else {
            head3.next = new ListNode(val);
        }
        return head3.next;
    }

    public ListNode mergeTwoListsInPlace(ListNode head1, ListNode head2) {

        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.val > head2.val) {
            return mergeTwoListsInPlace(head2, head1);
        }

        if (head1.next == null) {
            head1.next = head2;
            return head1;
        }
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        ListNode next1 = head1.next;
        ListNode next2 = head2.next;

        while (next1 != null && curr2 != null) {

            if (curr1.val <= curr2.val && curr2.val <= next1.val) {
                next2 = curr2.next;
                curr1.next = curr2;
                curr2.next = next1;

                curr1 = curr2;
                curr2 = next2;
            } else {
                if (next1.next != null) {
                    next1 = next1.next;
                    curr1 = curr1.next;
                } else {
                    next1.next = curr2;
                    return head1;
                }
            }
        }
        return head1;

    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(8);
        head1.next.next = new ListNode(20);
        head1.next.next.next = new ListNode(27);

        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(11);
        head2.next.next = new ListNode(15);
        head2.next.next.next = new ListNode(22);
        head2.next.next.next.next = new ListNode(23);
        head2.next.next.next.next.next = new ListNode(37);
        head2.next.next.next.next.next.next = new ListNode(44);

        ListNode head = new MergeTwoSortedList().mergeTwoListsInPlace(head1, head2);
        if (head != null) {
            head.printNodes();
        }
    }


}
