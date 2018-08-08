package com.jenkinspipelineexample.controller;

import org.junit.Assert;
import org.junit.Test;

public class SomeUtilTest {

    @Test
    public void checkWelcomeCorrectly() {
        SomeUtil someUtil = new SomeUtil();
        Assert.assertEquals("Welcome Joe", someUtil.welcome("Joe"));
    }
}
