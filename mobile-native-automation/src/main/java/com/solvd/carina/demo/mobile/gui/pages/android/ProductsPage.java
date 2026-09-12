package com.solvd.carina.demo.mobile.gui.pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(
        pageType = Type.ANDROID_PHONE,
        parentClass = ProductsPageBase.class)
public class ProductsPage extends ProductsPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
    private ExtendedWebElement productsTitle;

    @FindBy(xpath = "(//android.widget.TextView[@text='ADD TO CART'])[1]")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "(//android.widget.TextView[@text='ADD TO CART'])[2]")
    private ExtendedWebElement bikeLightAddToCartButton;

    @FindBy(xpath = "//*[@content-desc='test-Cart']")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//*[@content-desc='test-Menu']")
    private ExtendedWebElement menuButton;

    @FindBy(xpath = "//*[@content-desc='test-LOGOUT']")
    private ExtendedWebElement logoutButton;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return productsTitle.isElementPresent();
    }

    @Override
    public void addFirstProductToCart() {
        addToCartButton.click();
    }

    @Override
    public CartPageBase openCart() {
        cartButton.click();
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public void openMenu() {
        menuButton.click();
    }

    @Override
    public LoginPageBase logout() {
        openMenu();
        logoutButton.click();
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public void addBikeLightToCart() {
        bikeLightAddToCartButton.click();
    }
}