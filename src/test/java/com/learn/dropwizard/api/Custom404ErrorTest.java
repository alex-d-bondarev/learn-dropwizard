package com.learn.dropwizard.api;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Custom404ErrorTest {

    @Test
    public void test404Code(){
        Custom404Error custom404Error = new Custom404Error();
        Assert.assertEquals(custom404Error.getCode(), 404);
    }

    @Test
    public void test404Message(){
        Custom404Error custom404Error = new Custom404Error();
        Assert.assertEquals(custom404Error.getMessage(), "Custom page not found error");
    }
}
