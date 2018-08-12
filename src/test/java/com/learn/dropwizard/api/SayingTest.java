package com.learn.dropwizard.api;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SayingTest {
    @Test
    public void testSayingId(){
        Saying testSaying = new Saying(10, "");
        Assert.assertEquals(10, testSaying.getId());
    }

    @Test
    public void testSayingContent(){
        Saying testSaying = new Saying(11, "test");
        Assert.assertEquals("test", testSaying.getContent());
    }

    @Test
    public void testSayingConstructor(){
        Saying testSaying = new Saying();
        Assert.assertNull(testSaying.getContent());
    }
}
