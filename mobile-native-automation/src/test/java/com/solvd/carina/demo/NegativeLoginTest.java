package com.solvd.carina.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.core.IAbstractTest;

public class NegativeLoginTest implements IAbstractTest {

    @Test
    public void invalidLoginTest() {

        LoginPageBase loginPage =
                initPage(getDriver(), LoginPageBase.class);

        loginPage.login(
                "invalid_user",
                "invalid_password");

        Assert.assertTrue(
                loginPage.isErrorMessageDisplayed(),
                "Error message is not displayed");
    }
}