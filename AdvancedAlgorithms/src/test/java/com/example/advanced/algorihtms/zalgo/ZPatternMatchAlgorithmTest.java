package com.example.advanced.algorihtms.zalgo;

import com.example.advanced.algorithms.zalgo.ZPatternMatchAlgorithm;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class ZPatternMatchAlgorithmTest {
    ZPatternMatchAlgorithm patternMatchAlgorithm = null;

    @Before
    public void init() {
        patternMatchAlgorithm = new ZPatternMatchAlgorithm();
    }

    @Test
    public void testCreateLongString() {
        Assert.assertArrayEquals("abcd$efgh".toCharArray(),
                patternMatchAlgorithm.createLongString("efgh".toCharArray(),
                        "abcd".toCharArray()));
    }

    @Test
    public void testZTable() {
        Assert.assertArrayEquals(new int[]{0, 0, 0, 1, 2, 0, 0},
                patternMatchAlgorithm.prepareZTable("aabb".toCharArray(),
                        "ab".toCharArray()));
        Assert.assertArrayEquals(new int[]{0, 1, 0, 0, 0, 3, 1, 0, 2, 1},
                patternMatchAlgorithm.prepareZTable("baabaa".toCharArray(),
                        "aab".toCharArray()));
    }

    @Test
    public void testPatternMatch() {
        Assert.assertEquals(1,
                patternMatchAlgorithm.searchPattern("Hello".toCharArray(), "el".toCharArray()));
        Assert.assertEquals(2,
                patternMatchAlgorithm.searchPattern("Hello".toCharArray(), "ll".toCharArray()));
        Assert.assertEquals(0,
                patternMatchAlgorithm.searchPattern("Hello".toCharArray(), "Hel".toCharArray()));
        Assert.assertEquals(-1,
                patternMatchAlgorithm.searchPattern("Hello".toCharArray(), "elx".toCharArray()));
    }

    @Test
    public void testAllPatternMatch() {
        String text = "Hellololo";
        String pattern = "lo";
        int expected[] = new int[text.length()];
        Arrays.fill(expected, -1);
        expected[0] = 3;
        expected[1] = 5;
        expected[2] = 7;
        Assert.assertArrayEquals(expected,
                patternMatchAlgorithm.searchAllPattern(text.toCharArray(), pattern.toCharArray()));
    }

}
