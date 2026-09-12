package com.solvd.carina.demo.mobile.gui.pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(
        pageType = Type.ANDROID_PHONE,
        parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='YOUR CART']")
    private ExtendedWebElement cartTitle;

    @FindBy(xpath = "//*[@text='Sauce Labs Backpack']")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//*[@text='REMOVE']")
    private ExtendedWebElement removeButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return cartTitle.isElementPresent();
    }

    @Override
    public boolean isProductDisplayed() {
        return productName.isElementPresent();
    }

    @Override
    public void removeProduct() {
        removeButton.click();
    }

    @Override
    public boolean isCartEmpty() {
        productName.pause(2);
        return !productName.isElementPresent(3);
    }
}