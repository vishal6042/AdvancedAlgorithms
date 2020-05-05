package com.example.advanced.algorihtms.kmp;

import com.example.advanced.algorithms.kmp.KMPPatternMatch;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KMPPatternMatchTest {

    KMPPatternMatch kmpPatternMatch = null;

    @Before
    public void init() {
        kmpPatternMatch = new KMPPatternMatch();
    }

    @Test
    public void testComputeLPSArray() {
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3},
                kmpPatternMatch.computeLPSArray("AAAA".toCharArray()));
        Assert.assertArrayEquals(new int[]{0, 0, 0, 0, 0},
                kmpPatternMatch.computeLPSArray("ABCDE".toCharArray()));
        Assert.assertArrayEquals(new int[]{0, 1, 0, 1, 2, 0, 1, 2, 3, 4, 5},
                kmpPatternMatch.computeLPSArray("AABAACAABAA".toCharArray()));
        Assert.assertArrayEquals(new int[]{0, 1, 2, 0, 1, 2, 3, 3, 3, 4},
                kmpPatternMatch.computeLPSArray("AAACAAAAAC".toCharArray()));
        Assert.assertArrayEquals(new int[]{0, 1, 2, 0, 1, 2, 3},
                kmpPatternMatch.computeLPSArray("AAABAAA".toCharArray()));
    }

    @Test
    public void testKMPPatternSearch() {
        Assert.assertEquals(10,
                kmpPatternMatch.searchPattern("ABABDABACDABABCABAB".toCharArray(),
                        "ABABCABAB".toCharArray()));
        Assert.assertEquals(10,
                kmpPatternMatch.searchPattern("THIS IS A TEST TEXT".toCharArray(),
                        "TEST".toCharArray()));

        Assert.assertEquals(0,
                kmpPatternMatch.searchPattern("AABAACAADAABAABA".toCharArray(),
                        "AABA".toCharArray()));
        Assert.assertEquals(-1,
                kmpPatternMatch.searchPattern("AABAACAADAABAABA".toCharArray(),
                        "XXAB".toCharArray()));
    }
}
