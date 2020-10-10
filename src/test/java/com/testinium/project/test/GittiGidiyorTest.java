package com.testinium.project.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GittiGidiyorTest extends BaseTestKeyword {

    @Test
    public void Tests() throws InterruptedException {

        assertEquals("https://www.gittigidiyor.com/",driver.getCurrentUrl());
        SignUp(
                "NAME",
                "SURNAME",
                "testinium@sahabt.com",
                "testinium1453@",
                "5555555555"
                );

        SearchProductAddToCart("Telefon");

        Login("MAIL","PASSWORD");

        AddLocation("PASSWORD");


    }

}
