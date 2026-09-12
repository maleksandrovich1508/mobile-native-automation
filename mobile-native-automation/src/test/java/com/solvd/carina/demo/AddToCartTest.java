package com.solvd.carina.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import com.zebrunner.carina.core.IAbstractTest;

public class AddToCartTest implements IAbstractTest {

    @Test
    public void addProductToCartTest() {

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

        Assert.assertTrue(
                cartPage.isOpened(),
                "Cart page is not opened");

        Assert.assertTrue(
                cartPage.isProductDisplayed(),
                "Product is not displayed in cart");
    }
}