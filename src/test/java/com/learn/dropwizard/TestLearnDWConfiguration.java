package com.learn.dropwizard;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLearnDWConfiguration {
    @Test
    public void testDefaultWaitTimeout(){
        String waitTimeout = "123";
        LearnDWConfiguration configuration = new LearnDWConfiguration();
        configuration.setDefaultWaitTimeout(waitTimeout);
        Assert.assertEquals(waitTimeout, configuration.getDefaultWaitTimeout());
    }
}
