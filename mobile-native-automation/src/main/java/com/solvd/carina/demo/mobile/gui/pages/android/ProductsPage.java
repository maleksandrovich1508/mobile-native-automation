package com.solvd.carina.demo.mobile.gui.pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

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
}
