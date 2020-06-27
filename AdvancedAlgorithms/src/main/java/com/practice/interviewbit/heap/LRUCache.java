package com.practice.interviewbit.heap;

import java.util.HashMap;

public class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            prev = next = null;
        }
    }

    private HashMap<Integer, Node> map;
    private int capacity;
    int size;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        map = new HashMap<>(capacity);
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
    }

    private void addNode(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            int res = node.val;
            deleteNode(node);
            addNode(node);
            return res;
        }
        return -1;
    }

    public void set(int key, int value) {

        if (map.get(key) != null) {
            Node node = map.get(key);
            node.val = value;
            deleteNode(node);
            addNode(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (size < capacity) {
                size++;
            } else {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
            }
            addNode(node);
        }

    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.set(1, 10);
        cache.set(2, 20);
        System.out.println("Value for the key: 1 is " +
                cache.get(1)); // returns 10
        cache.set(3, 30);
        System.out.println("Value for the key: 2 is " +
                cache.get(2)); // returns -1 (not found)

        cache.set(4, 40);
        System.out.println("Value for the key: 1 is " +
                cache.get(1)); // returns -1 (not found)
        System.out.println("Value for the key: 3 is " +
                cache.get(3)); // returns 30
        System.out.println("Value for the key: 4 is " +
                cache.get(4)); // return 40
    }
}
