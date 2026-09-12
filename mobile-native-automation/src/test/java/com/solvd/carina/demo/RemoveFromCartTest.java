package com.solvd.carina.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import com.zebrunner.carina.core.IAbstractTest;

public class RemoveFromCartTest implements IAbstractTest {

    @Test
    public void removeProductFromCartTest() {

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
                cartPage.isProductDisplayed(),
                "Product was not added to cart");

        cartPage.removeProduct();

        Assert.assertTrue(
                cartPage.isCartEmpty(),
                "Cart is not empty");
    }
}
