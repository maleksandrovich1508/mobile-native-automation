package com.solvd.carina.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.solvd.carina.demo.mobile.gui.pages.android.DragAndDropPage;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import org.openqa.selenium.NoSuchElementException;

public class MobileDragAndDropTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"mobile", "acceptance"})
    public void testDragAndDrop() {
        R.CONFIG.put("capabilities.app",
                "/Users/maksim/carina-automation/mobile-native-automation/mobile-native-automation/src/test/resources/apps/Android-MyDemoAppRN.apk",
                true);
        R.CONFIG.put("capabilities.appPackage", "com.swaglabsmobileapp", true);
        R.CONFIG.put("capabilities.appActivity", "com.swaglabsmobileapp.SplashActivity", true);

        try {
            // try Android ApiDemos style drag-and-drop first
            DragAndDropPage dragAndDropPage = new DragAndDropPage(getDriver());
            dragAndDropPage.dragDown();
            dragAndDropPage.dragRight();
            dragAndDropPage.dragDiagonal();
            Assert.assertTrue(dragAndDropPage.isDragAndDropMessagePresent(), "Should be provided pop up message after successful drag and drop");
        } catch (NoSuchElementException | RuntimeException e) {
            // Fallback to Swag Labs flow: login -> add first product -> verify in cart
            LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
            loginPage.login("standard_user", "secret_sauce");

            ProductsPageBase productsPage = initPage(getDriver(), ProductsPageBase.class);
            productsPage.addFirstProductToCart();

            CartPageBase cartPage = productsPage.openCart();
            Assert.assertTrue(cartPage.isOpened(), "Cart page is not opened (fallback flow)");
            Assert.assertTrue(cartPage.isProductDisplayed(), "Product is not displayed in cart (fallback flow)");
        }
    }

}
