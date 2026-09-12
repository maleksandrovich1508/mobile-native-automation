package com.solvd.carina.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import com.zebrunner.carina.core.IAbstractTest;

public class ContinueShoppingTest implements IAbstractTest {

    @Test
    public void continueShoppingTest() {

        LoginPageBase loginPage =
                initPage(getDriver(), LoginPageBase.class);

        loginPage.login(
                "standard_user",
                "secret_sauce");

        ProductsPageBase productsPage =
                initPage(getDriver(), ProductsPageBase.class);

        productsPage.addFirstProductToCart();

        CartPageBase cartPage =
                productsPage.openCart();

        ProductsPageBase returnedProductsPage =
                cartPage.clickContinueShopping();

        Assert.assertTrue(
                returnedProductsPage.isOpened(),
                "Products page is not opened");
    }
}