package com.solvd.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class CheckoutPageBase extends AbstractPage {

    public CheckoutPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract void enterFirstName(String firstName);

    public abstract void enterLastName(String lastName);

    public abstract void enterZipCode(String zipCode);

    public abstract void clickContinue();

    public abstract void fillCheckoutInformation(
            String firstName,
            String lastName,
            String zipCode);

    public abstract boolean isErrorMessageDisplayed();
}