package com.solvd.carina.demo.mobile.gui.pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.CheckoutPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
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

    @FindBy(xpath = "//*[@text='Sauce Labs Backpack']")
    private ExtendedWebElement backpackProduct;

    @FindBy(xpath = "//*[@text='Sauce Labs Bike Light']")
    private ExtendedWebElement bikeLightProduct;

    @FindBy(xpath = "//*[@content-desc='test-CHECKOUT']")
    private ExtendedWebElement checkoutButton;

    @FindBy(xpath = "//*[@content-desc='test-CONTINUE SHOPPING']")
    private ExtendedWebElement continueShoppingButton;

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
    public boolean isBackpackDisplayed() {
        return backpackProduct.isElementPresent();
    }

    @Override
    public boolean isBikeLightDisplayed() {
        try {
            bikeLightProduct.scrollTo();
            return bikeLightProduct.isElementPresent(5);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean isCartEmpty() {
        productName.pause(2);
        return !productName.isElementPresent(3);
    }

    @Override
    public ProductsPageBase clickContinueShopping() {
        continueShoppingButton.click();
        return initPage(getDriver(), ProductsPageBase.class);
    }

    @Override
    public CheckoutPageBase clickCheckout() {
        checkoutButton.click();
        return initPage(getDriver(), CheckoutPageBase.class);
    }
}