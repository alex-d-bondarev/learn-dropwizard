package com.learn.dropwizard.api;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitingTest {

    @Test
    public void testDefaultMessage(){
        Waiting waiting = new Waiting();
        Assert.assertEquals(waiting.getMessage(), "Waited %d milliseconds");
    }

    @Test
    public void testDefaultTimeout(){
        Waiting waiting = new Waiting();
        Assert.assertEquals(waiting.getSleepTimeout(), 0);
    }

    @Test
    public void testThreadSleep50(){
        testWaited(50);
    }

    @Test
    public void testThreadSleep150(){
        testWaited(150);
    }

    private void testWaited(long waited){
        long startTime = System.nanoTime();
        Waiting waiting = new Waiting(waited);
        long elapsedTime = System.nanoTime() - startTime;
        Assert.assertTrue(elapsedTime >= waited);
    }
}
