package com.example.simple.algorithms.sorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SortTest {

    private InsertionSort insertionSort;
    private MergeSort mergeSort;
    private QuickSort quickSort;

    @Before
    public void init() {
        insertionSort = new InsertionSort();
        mergeSort = new MergeSort();
        quickSort = new QuickSort();
    }

    @Test
    public void testInsertionSort() {
        int arr[] = {1, 2, 3, 4, 5};
        insertionSort.doInsertionSort(arr);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
        arr = new int[]{1, 10, 2, 13, 4, 15};
        insertionSort.doInsertionSort(arr);
        Assert.assertArrayEquals(new int[]{1, 2, 4, 10, 13, 15}, arr);

    }

    @Test
    public void testMergeSort() {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        mergeSort.doMergeSort(arr);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, arr);
        arr = new int[]{1, 10, 2, 13, 4, 15};
        mergeSort.doMergeSort(arr);
        Assert.assertArrayEquals(new int[]{1, 2, 4, 10, 13, 15}, arr);

    }

    @Test
    public void testQuickSort() {
        int arr[] = {1, 12, 13, 4, 5, 16, 7, 8};
        quickSort.doQuickSort(arr);
        Assert.assertArrayEquals(new int[]{1, 4, 5, 7, 8, 12, 13, 16}, arr);
        arr = new int[]{1, 10, 2, 13, 4, 15};
        quickSort.doQuickSort(arr);
        Assert.assertArrayEquals(new int[]{1, 2, 4, 10, 13, 15}, arr);

    }
}
