package com.solvd.carina.demo.mobile.gui.pages.ios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.demo.mobile.gui.pages.common.CheckoutPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(
        pageType = Type.IOS_PHONE,
        parentClass = CheckoutPageBase.class)
public class CheckoutPage extends CheckoutPageBase {

    @FindBy(xpath = "//*[@name='CHECKOUT: YOUR INFORMATION']")
    private ExtendedWebElement checkoutTitle;

    @FindBy(xpath = "//*[@name='test-First Name']")
    private ExtendedWebElement firstNameField;

    @FindBy(xpath = "//*[@name='test-Last Name']")
    private ExtendedWebElement lastNameField;

    @FindBy(xpath = "//*[@name='test-Postal Code']")
    private ExtendedWebElement zipField;

    @FindBy(xpath = "//*[@name='test-CONTINUE']")
    private ExtendedWebElement continueBtn;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return checkoutTitle.isElementPresent();
    }

    @Override
    public void typeFirstName(String text) {
        firstNameField.type(text);
    }

    @Override
    public void typeLastName(String text) {
        lastNameField.type(text);
    }

    @Override
    public void typeZipCode(String text) {
        zipField.type(text);
    }

    @Override
    public void clickContinue() {
        continueBtn.click();
    }
}
