package com.learn.dropwizard;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLearnDWApplication {
    @Test
    public void testApplicationName(){
        LearnDWApplication app = new LearnDWApplication();
        Assert.assertEquals(app.getName(), "LearnDW");
    }
}
