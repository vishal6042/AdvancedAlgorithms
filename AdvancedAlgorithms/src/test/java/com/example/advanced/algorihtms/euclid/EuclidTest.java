package com.example.advanced.algorihtms.euclid;

import com.example.advanced.algorithms.euclid.EuclidAlgorithm;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EuclidTest {
    EuclidAlgorithm algorithm = null;

    @Before
    public void init() {
        algorithm = new EuclidAlgorithm();
    }

    @Test
    public void gcd() {
        Assert.assertEquals(2, algorithm.gcd(10, 2));
        Assert.assertEquals(2, algorithm.gcd(22, 6));
    }

    @Test
    public void gcd2() {
        Assert.assertEquals(2, algorithm.gcd2(10, 2));
        Assert.assertEquals(2, algorithm.gcd2(22, 6));
    }

    @Test
    public void gcdVsGcd2() {
        Assert.assertEquals(algorithm.gcd(180,32), algorithm.gcd2(180, 32));
        Assert.assertEquals(algorithm.gcd(100,32), algorithm.gcd2(100 , 32));
    }
}
