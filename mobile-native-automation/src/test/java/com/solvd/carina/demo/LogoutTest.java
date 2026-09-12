package com.solvd.carina.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import com.zebrunner.carina.core.IAbstractTest;

public class LogoutTest implements IAbstractTest {

    @Test
    public void logoutTest() {

        LoginPageBase loginPage =
                initPage(getDriver(), LoginPageBase.class);

        loginPage.login(
                "standard_user",
                "secret_sauce");

        ProductsPageBase productsPage =
                initPage(getDriver(), ProductsPageBase.class);

        LoginPageBase returnedLoginPage =
                productsPage.logout();

        Assert.assertNotNull(
                returnedLoginPage,
                "Login page was not returned after logout");
    }
}