package com.practice.interviewbit.heap;

import com.practice.interviewbit.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {
    public ListNode mergeKLists(ArrayList<ListNode> a) {

        if (a.size() == 0) {
            return null;
        }
        ListNode head = null;
        ListNode tail = null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        heap.addAll(a);

        while (!heap.isEmpty()) {
            ListNode min = heap.peek();
            heap.poll();
            if (head == null) {
                head = tail = min;
            } else {
                tail.next = min;
                tail = tail.next;
            }
            if (min.next != null) {
                heap.add(min.next);
            }
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(8);
        head1.next.next = new ListNode(120);
        head1.next.next.next = new ListNode(127);

        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(11);
        head2.next.next = new ListNode(115);
        head2.next.next.next = new ListNode(122);
        head2.next.next.next.next = new ListNode(133);
        head2.next.next.next.next.next = new ListNode(137);
        head2.next.next.next.next.next.next = new ListNode(414);

        ListNode head3 = new ListNode(14);
        head3.next = new ListNode(23);
        head3.next.next = new ListNode(35);
        head3.next.next.next = new ListNode(52);
        head3.next.next.next.next = new ListNode(123);
        head3.next.next.next.next.next = new ListNode(137);
        head3.next.next.next.next.next.next = new ListNode(144);

        ArrayList<ListNode> a = new ArrayList<ListNode>();
        a.add(head1);
        a.add(head2);
        a.add(head3);


        ListNode ans = new MergeKSortedList().mergeKLists(a);
        if (ans != null) ans.printNodes();
    }
}
