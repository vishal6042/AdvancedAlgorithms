package com.practice.interviewbit.heap;

class MinHeap {
    private final int[] arr;
    private final int capacity;
    private int heapSize;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        heapSize = 0;
    }

    public int getParent(int i) {
        return (i - 1) / 2;
    }

    public int getLeft(int i) {
        return 2 * i + 1;
    }

    public int getRight(int i) {
        return 2 * i + 2;
    }

    public void insert(int key) {
        if (heapSize == capacity) {
            throw new IllegalStateException("Heap is full");
        }
        heapSize++;
        int i = heapSize - 1;
        arr[i] = key;

        while (i != 0 && arr[getParent(i)] > arr[i]) {
            swapElem(i, getParent(i));
            i = getParent(i);
        }
    }

    private void swapElem(int i, int parent) {
        int temp = arr[i];
        arr[i] = arr[parent];
        arr[parent] = temp;
    }

    public void printHeap() {
        System.out.println("**********************");
        for (int i = 0; i < heapSize; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("**********************");
    }

    public int getMin() {
        if (heapSize > 0) {
            return arr[0];
        }
        throw new IllegalStateException("Empty Heap");
    }

    public void deleteKeyAtIndex(int i) {
        arr[i] = Integer.MIN_VALUE;
        while (i != 0 && arr[getParent(i)] > arr[i]) {
            swapElem(i, getParent(i));
            i = getParent(i);
        }

        extractMin();
    }

    public int extractMin() {
        if (heapSize <= 0) {
            throw new IllegalStateException("Empty Heap");
        }
        if (heapSize == 1) {
            heapSize--;
            return arr[0];
        }

        int root = arr[0];
        arr[0] = arr[heapSize - 1];
        heapSize--;
        heapify(0);
        return root;
    }

    private void heapify(int index) {
        int left = getLeft(index);
        int right = getRight(index);

        int smallest = index;
        if (left < heapSize && arr[left] < arr[index]) {
            smallest = left;
        }
        if (right < heapSize && arr[right] < arr[smallest]) {
            smallest = right;
        }
        if (smallest != index) {
            swapElem(index, smallest);
            heapify(smallest);
        }
    }
}

public class HeapImplementation {

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(12);
        minHeap.insert(3);
        minHeap.insert(6);
        minHeap.insert(23);
        minHeap.insert(7);
        minHeap.insert(4);
        minHeap.insert(8);
        minHeap.insert(142);

        minHeap.printHeap();
        int min = minHeap.getMin();
        System.out.println("Min Element" + min);
        minHeap.deleteKeyAtIndex(3);
        minHeap.printHeap();
        min = minHeap.extractMin();
        System.out.println("Min Element" + min);
        minHeap.printHeap();
        min = minHeap.getMin();
        System.out.println("Min Element" + min);
    }
}
