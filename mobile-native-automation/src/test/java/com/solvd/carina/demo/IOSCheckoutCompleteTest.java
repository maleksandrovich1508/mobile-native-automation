package com.solvd.carina.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.CheckoutCompletePageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.CheckoutPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;

public class IOSCheckoutCompleteTest implements IAbstractTest {

    @Test
    public void checkoutCompleteTestIOS() {

        // iOS capabilities
        R.CONFIG.put("capabilities.platformName", "iOS", true);
        R.CONFIG.put("capabilities.automationName", "XCUITest", true);
        R.CONFIG.put("capabilities.deviceName", "iPhone 17", true);

        // iOS application
        R.CONFIG.put(
                "capabilities.app",
                "/Users/maksim/Downloads/iOS.Simulator.SauceLabs.Mobile.Sample.app.2.7.1.app",
                true);

        // remove Android capabilities
        R.CONFIG.put("capabilities.appPackage", "", true);
        R.CONFIG.put("capabilities.appActivity", "", true);

        try {

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

            CheckoutCompletePageBase completePage =
                    checkoutPage.finishCheckout();

            Assert.assertTrue(
                    completePage.isOpened(),
                    "Checkout complete page is not opened on iOS");

        } catch (Exception e) {

            e.printStackTrace();

            Assert.fail(
                    "iOS test failed: " + e.getMessage());
        }
    }
}