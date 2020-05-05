package com.example.advanced.algorihtms.bruteforce;

import com.example.advanced.algorithms.bruteforce.PatternMatchBruteForce;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class PatternMatchBruteForceTest {

    PatternMatchBruteForce patternMatchBruteForce = null;
    char[] array;

    @Before
    public void init() {
        patternMatchBruteForce = new PatternMatchBruteForce();
        String text = new String("academy.learnprogramming of advanced algorithms");
        array = text.toCharArray();
    }

    @Test
    public void testFirstMatch() {
        Assert.assertEquals(0,
                patternMatchBruteForce.findFirstMatch(array, new char[]{'a', 'c'}));
        Assert.assertEquals(8,
                patternMatchBruteForce.findFirstMatch(array, new char[]{'l', 'e'}));
        Assert.assertEquals(16,
                patternMatchBruteForce.findFirstMatch(array, new char[]{'g'}));
        Assert.assertEquals(-1,
                patternMatchBruteForce.findFirstMatch(array, new char[]{'x'}));
    }

    @Test
    public void testEveryMatch() {
        int arr[] = new int[array.length - 3 + 1];
        Arrays.fill(arr, -1);
        Assert.assertArrayEquals(arr,
                patternMatchBruteForce.findAllMatch(array, new char[]{'x', 'x', 'x'}));
        arr = new int[array.length - 1 + 1];
        Arrays.fill(arr, -1);
        arr[0] = 0;
        arr[1] = 2;
        arr[2] = 10;
        arr[3] = 18;
        arr[4] = 28;
        arr[5] = 31;
        arr[6] = 37;
        Assert.assertArrayEquals(arr,
                patternMatchBruteForce.findAllMatch(array, new char[]{'a'}));
    }
}
