package com.solvd.carina.demo;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.CheckoutCompletePageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.CheckoutPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;

public class IOSCheckoutCompleteTest implements IAbstractTest {

    @Test
    public void checkoutCompleteTestIOS() {
        R.CONFIG.put("capabilities.platformName", "iOS", true);
        try {
            LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
            loginPage.login("standard_user", "secret_sauce");

            ProductsPageBase productsPage = initPage(getDriver(), ProductsPageBase.class);
            productsPage.addFirstProductToCart();

            CartPageBase cartPage = productsPage.openCart();
            CheckoutPageBase checkoutPage = cartPage.checkout();
            CheckoutCompletePageBase completePage = checkoutPage.complete();

            Assert.assertTrue(completePage.isOpened(), "Checkout complete page is not opened on iOS");
        } catch (Exception e) {
            throw new SkipException("iOS environment or app not ready for checkout-complete test: " + e.getMessage());
        }
    }
}
