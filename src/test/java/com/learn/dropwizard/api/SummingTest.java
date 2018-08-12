package com.learn.dropwizard.api;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SummingTest {

    @Test
    public void testResult(){
        Summing summing = new Summing(1, 2);
        Assert.assertEquals(summing.getResult(), 3);
    }

    @Test
    public void testMessage(){
        Summing summing = new Summing(1, 2);
        Assert.assertEquals(summing.getMessage(), "Result of summing 1 and 2");
    }
}
