package com.example.advanced.algorihtms.boyermoore;

import com.example.advanced.algorithms.boyermoore.BoyerMooreHorsePatternMatch;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoyerMooreHorsePatternMatchTest {

    BoyerMooreHorsePatternMatch patternMatch = null;

    @Before
    public void init() {
        patternMatch = new BoyerMooreHorsePatternMatch();
    }

    @Test
    public void testSearch() {
        Assert.assertEquals(10,
                patternMatch.searchPattern("ABABDABACDABABCABAB".toCharArray(),
                        "ABABCABAB".toCharArray()));
        Assert.assertEquals(10,
                patternMatch.searchPattern("THIS IS A TEST TEXT".toCharArray(),
                        "TEST".toCharArray()));

        Assert.assertEquals(0,
                patternMatch.searchPattern("AABAACAADAABAABA".toCharArray(),
                        "AABA".toCharArray()));
//        Assert.assertEquals(-1,
//                patternMatch.searchPattern("AABAACAADAABAABA".toCharArray(),
//                        "XXAB".toCharArray()));
    }

    @Test
    public void testHorsePoolTable() {
        int[] table = patternMatch.preprocessTable("test".toCharArray());
        Assert.assertEquals(1, table['t']);
        Assert.assertEquals(2, table['e']);
        Assert.assertEquals(1, table['s']);
        Assert.assertEquals(4, table['x']);

        table = patternMatch.preprocessTable("abc".toCharArray());
        Assert.assertEquals(2, table['a']);
        Assert.assertEquals(1, table['b']);
        Assert.assertEquals(3, table['c']);
        Assert.assertEquals(3, table['g']);

        table = patternMatch.preprocessTable("abcdb".toCharArray());
        Assert.assertEquals(4, table['a']);
        Assert.assertEquals(1, table['b']);
        Assert.assertEquals(2, table['c']);
        Assert.assertEquals(1, table['d']);
        Assert.assertEquals(5, table['j']);
    }
}
