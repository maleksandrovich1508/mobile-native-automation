package com.solvd.carina.demo.mobile.gui.pages.ios;

import org.openqa.selenium.WebDriver;

import com.solvd.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;

@DeviceType(
        pageType = Type.IOS_PHONE,
        parentClass = ProductsPageBase.class)
public class ProductsPage extends ProductsPageBase {

    @org.openqa.selenium.support.FindBy(xpath = "//*[@name='PRODUCTS']")
    private com.zebrunner.carina.webdriver.decorator.ExtendedWebElement productsTitle;

    @org.openqa.selenium.support.FindBy(xpath = "(//*[@name='ADD TO CART'])[1]")
    private com.zebrunner.carina.webdriver.decorator.ExtendedWebElement addToCartButton;

    @org.openqa.selenium.support.FindBy(xpath = "(//*[@name='ADD TO CART'])[2]")
    private com.zebrunner.carina.webdriver.decorator.ExtendedWebElement bikeLightAddToCartButton;

    @org.openqa.selenium.support.FindBy(xpath = "//*[@name='test-Cart']")
    private com.zebrunner.carina.webdriver.decorator.ExtendedWebElement cartButton;

    @org.openqa.selenium.support.FindBy(xpath = "//*[@name='test-Menu']")
    private com.zebrunner.carina.webdriver.decorator.ExtendedWebElement menuButton;

    @org.openqa.selenium.support.FindBy(xpath = "//*[@name='test-LOGOUT']")
    private com.zebrunner.carina.webdriver.decorator.ExtendedWebElement logoutButton;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return productsTitle.isElementPresent(2);
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
    public void addBikeLightToCart() {
        bikeLightAddToCartButton.click();
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
}