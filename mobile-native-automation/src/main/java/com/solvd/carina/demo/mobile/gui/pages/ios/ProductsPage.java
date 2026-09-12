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

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return false;
    }

    @Override
    public void addFirstProductToCart() {
    }

    @Override
    public CartPageBase openCart() {
        return null;
    }

    @Override
    public void addBikeLightToCart() {
    }

    @Override
    public void openMenu() {
    }

    @Override
    public LoginPageBase logout() {
        return null;
    }
}