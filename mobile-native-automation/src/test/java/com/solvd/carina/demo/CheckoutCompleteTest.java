package com.solvd.carina.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.CheckoutCompletePageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.CheckoutPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import com.zebrunner.carina.core.IAbstractTest;

public class CheckoutCompleteTest implements IAbstractTest {

    @Test
    public void checkoutCompleteTest() {

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

        CheckoutPageBase checkoutPage =
                cartPage.clickCheckout();

        checkoutPage.fillCheckoutInformation(
                "Maksim",
                "QA",
                "00001");

        CheckoutCompletePageBase completePage =
                checkoutPage.finishCheckout();

        Assert.assertTrue(
                completePage.isOpened(),
                "Checkout Complete page is not opened");
    }
}