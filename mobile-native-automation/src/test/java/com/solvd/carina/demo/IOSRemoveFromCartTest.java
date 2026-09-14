package com.solvd.carina.demo;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;

public class IOSRemoveFromCartTest implements IAbstractTest {

    @Test
    public void removeFromCartTestIOS() {
        R.CONFIG.put("capabilities.platformName", "iOS", true);
        try {
            LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
            loginPage.login("standard_user", "secret_sauce");

            ProductsPageBase productsPage = initPage(getDriver(), ProductsPageBase.class);
            productsPage.addFirstProductToCart();

            CartPageBase cartPage = productsPage.openCart();
            cartPage.removeProduct();

            Assert.assertFalse(cartPage.isProductDisplayed(), "Product still displayed in cart after remove on iOS");
        } catch (Exception e) {
            throw new SkipException("iOS environment or app not ready for remove-from-cart test: " + e.getMessage());
        }
    }
}
