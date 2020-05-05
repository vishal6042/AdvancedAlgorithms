package com.example.advanced.algorihtms.rabinkarp;

import com.example.advanced.algorithms.rabinkarp.RabinKarpPatternMatch;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RabinKarpPatternMatchTest {

    RabinKarpPatternMatch rabinKarpPatternMatch = null;

    @Before
    public void init() {
        rabinKarpPatternMatch = new RabinKarpPatternMatch();
    }

    @Test
    public void testIsEquals() {
        assertTrue(rabinKarpPatternMatch.isEquals("Hello".toCharArray(), 2, 4,
                "ll".toCharArray(), 2));
        assertTrue(rabinKarpPatternMatch.isEquals("THIS IS A TEST TEXT".toCharArray(), 10, 14,
                "TEST".toCharArray(), 4));
        assertTrue(rabinKarpPatternMatch.isEquals("AABAACAADAABAABA".toCharArray(), 9, 13,
                "AABA".toCharArray(), 4));
        assertTrue(rabinKarpPatternMatch.isEquals("VISHAL".toCharArray(), 3, 6,
                "HAL".toCharArray(), 3));
    }

    @Test
    public void testCalculateHash() {
        Assert.assertEquals(112384489L, rabinKarpPatternMatch.calculateHash("Hello".toCharArray(), 3));
        Assert.assertEquals(11663089000L, rabinKarpPatternMatch.calculateHash("Hello".toCharArray(), 4));
        Assert.assertEquals(1221042705148L, rabinKarpPatternMatch.calculateHash("sdfbvsdfbdsfb".toCharArray(), 5));
    }

    @Test
    public void testPatternMatch() {
        Assert.assertEquals(1,
                rabinKarpPatternMatch.searchPattern("Hello".toCharArray(), "el".toCharArray()));
        Assert.assertEquals(2,
                rabinKarpPatternMatch.searchPattern("Hello".toCharArray(), "ll".toCharArray()));
        Assert.assertEquals(0,
                rabinKarpPatternMatch.searchPattern("Hello".toCharArray(), "Hel".toCharArray()));
        Assert.assertEquals(-1,
                rabinKarpPatternMatch.searchPattern("Hello".toCharArray(), "elx".toCharArray()));
    }
}
