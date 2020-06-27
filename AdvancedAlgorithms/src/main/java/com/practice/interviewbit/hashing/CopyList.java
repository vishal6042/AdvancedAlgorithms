package com.practice.interviewbit.hashing;

import java.util.HashMap;

public class CopyList {
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode original = head;
        RandomListNode copy = null;

        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        while (original != null) {
            copy = new RandomListNode(original.label);
            map.put(original, copy);
            original = original.next;
        }
        original = head;
        while (original != null) {
            copy = map.get(original);
            copy.next = map.get(original.next);
            copy.random = map.get(original.random);
            original = original.next;
        }
        head = map.get(head);
        return head;
    }

}
