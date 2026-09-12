package com.solvd.carina.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import com.zebrunner.carina.core.IAbstractTest;

public class LoginTest implements IAbstractTest {

    @Test
    public void validLoginTest() {

        LoginPageBase loginPage =
                initPage(getDriver(), LoginPageBase.class);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        ProductsPageBase productsPage =
                initPage(getDriver(), ProductsPageBase.class);

        Assert.assertTrue(
                productsPage.isOpened(),
                "Products page is not opened"
        );
    }
}