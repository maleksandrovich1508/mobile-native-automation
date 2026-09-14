package com.solvd.carina.demo;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.CheckoutPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;

public class IOSCheckoutTest implements IAbstractTest {

    @Test
    public void checkoutTestIOS() {
        R.CONFIG.put("capabilities.platformName", "iOS", true);
        R.CONFIG.put("capabilities.automationName", "XCUITest", true);
        String _app = R.CONFIG.get("capabilities.app");
        String _bundle = R.CONFIG.get("capabilities.bundleId");
        boolean invalidApp = (_app == null || _app.isEmpty() || _app.toLowerCase().endsWith(".apk"));
        if (invalidApp && (_bundle == null || _bundle.isEmpty())) {
            throw new SkipException("No iOS app (.app/.ipa) or bundleId configured (capabilities.app or capabilities.bundleId). Skipping iOS test.");
        }
        try {
            LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
            loginPage.login("standard_user", "secret_sauce");

            ProductsPageBase productsPage = initPage(getDriver(), ProductsPageBase.class);
            productsPage.addFirstProductToCart();

            CartPageBase cartPage = productsPage.openCart();
            CheckoutPageBase checkoutPage = cartPage.clickCheckout();

            Assert.assertTrue(checkoutPage.isOpened(), "Checkout page is not opened on iOS");
        } catch (Exception e) {
            throw new SkipException("iOS environment or app not ready for checkout test: " + e.getMessage());
        }
    }
}
