package com.solvd.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class CheckoutCompletePageBase extends AbstractPage {

    public CheckoutCompletePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();
}