package com.practice.interviewbit.linkedlist;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        ListNode first = head1;
        ListNode second = head2;
        int carry = 0;
        ListNode thirdHead = null;
        ListNode thirdTail = null;

        while (first != null && second != null) {
            int val = first.val + second.val + carry;
            int finalVal = val % 10;
            carry = val / 10;
            if (thirdHead == null) {
                thirdHead = new ListNode(finalVal);
                thirdTail = thirdHead;
            } else {
                thirdTail.next = new ListNode(finalVal);
                thirdTail = thirdTail.next;
            }
            first = first.next;
            second = second.next;
        }

        while (first != null) {
            int val = first.val + carry;
            int finalVal = val % 10;
            carry = val / 10;
            thirdTail.next = new ListNode(finalVal);
            thirdTail = thirdTail.next;
            first = first.next;
        }
        while (second != null) {
            int val = second.val + carry;
            int finalVal = val % 10;
            carry = val / 10;
            thirdTail.next = new ListNode(finalVal);
            thirdTail = thirdTail.next;
            second = second.next;
        }
        if (carry != 0) {
            thirdTail.next = new ListNode(1);
            thirdTail = thirdTail.next;
        }

        return thirdHead;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
      //  head1.next = new ListNode(4);
      //  head1.next.next = new ListNode(3);
//        head1.next.next.next = new ListNode(4);

        ListNode head2 = new ListNode(9);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(9);

        ListNode head = new AddTwoNumbers().addTwoNumbers(head1, head2);
        if (head != null) {
            head.printNodes();
        }
    }
}
