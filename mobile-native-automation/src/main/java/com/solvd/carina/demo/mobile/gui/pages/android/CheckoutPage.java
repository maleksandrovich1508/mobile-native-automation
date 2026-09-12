package com.solvd.carina.demo.mobile.gui.pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.demo.mobile.gui.pages.common.CheckoutPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(
        pageType = Type.ANDROID_PHONE,
        parentClass = CheckoutPageBase.class)
public class CheckoutPage extends CheckoutPageBase {

    @FindBy(xpath = "//*[@text='CHECKOUT: INFORMATION']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[@content-desc='test-First Name']")
    private ExtendedWebElement firstNameField;

    @FindBy(xpath = "//*[@content-desc='test-Last Name']")
    private ExtendedWebElement lastNameField;

    @FindBy(xpath = "//*[@content-desc='test-Zip/Postal Code']")
    private ExtendedWebElement zipCodeField;

    @FindBy(xpath = "//*[@content-desc='test-CONTINUE']")
    private ExtendedWebElement continueButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return title.isElementPresent();
    }

    @Override
    public void enterFirstName(String firstName) {
        firstNameField.type(firstName);
    }

    @Override
    public void enterLastName(String lastName) {
        lastNameField.type(lastName);
    }

    @Override
    public void enterZipCode(String zipCode) {
        zipCodeField.type(zipCode);
    }

    @Override
    public void clickContinue() {
        continueButton.click();
    }

    @Override
    public void fillCheckoutInformation(
            String firstName,
            String lastName,
            String zipCode) {

        enterFirstName(firstName);
        enterLastName(lastName);
        enterZipCode(zipCode);

        clickContinue();
    }
}