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
    public void enterFirstName(String firstName) {
        firstNameField.type(firstName);
    }

    @Override
    public void enterLastName(String lastName) {
        lastNameField.type(lastName);
    }

    @Override
    public void enterZipCode(String zipCode) {
        zipField.type(zipCode);
    }

    @Override
    public void clickContinue() {
        continueBtn.click();
    }

    @Override
    public void fillCheckoutInformation(String firstName, String lastName, String zipCode) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterZipCode(zipCode);
    }

    @Override
    public boolean isErrorMessageDisplayed() {
        // sample app usually doesn't show error element for checkout; return false by default
        return false;
    }

    @Override
    public com.solvd.carina.demo.mobile.gui.pages.common.CheckoutCompletePageBase finishCheckout() {
        clickContinue();
        return initPage(getDriver(), com.solvd.carina.demo.mobile.gui.pages.common.CheckoutCompletePageBase.class);
    }
}
