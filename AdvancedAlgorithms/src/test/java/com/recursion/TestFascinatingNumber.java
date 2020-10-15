package com.recursion;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestFascinatingNumber {

    FascinatingNumber fascinatingNumber;

    @Before
    public void init() {
        fascinatingNumber = new FascinatingNumber();
    }

    @Test
    public void testCountDigit() {
        Assert.assertEquals(fascinatingNumber.countDigit(1241324), 7);
        Assert.assertEquals(fascinatingNumber.countDigit(1234), 4);
        Assert.assertEquals(fascinatingNumber.countDigit(12411324), 8);
        Assert.assertEquals(fascinatingNumber.countDigit(463124), 6);
        Assert.assertEquals(fascinatingNumber.countDigit(4), 1);

    }

    @Test
    public void testConcatenate() {
        Assert.assertArrayEquals(
                fascinatingNumber.concatenate(123,3453,123),
                "3213543321".toCharArray()
        );

        Assert.assertArrayEquals(
                fascinatingNumber.concatenate(123,3453,123, 546476),
                "3213543321674645".toCharArray()
        );

    }


}
