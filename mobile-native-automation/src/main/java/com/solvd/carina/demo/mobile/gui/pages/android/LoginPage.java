package com.solvd.carina.demo.mobile.gui.pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(
        pageType = Type.ANDROID_PHONE,
        parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(xpath = "//*[@content-desc='test-Username']")
    private ExtendedWebElement usernameField;

    @FindBy(xpath = "//*[@content-desc='test-Password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//*[@content-desc='test-LOGIN']")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeUsername(String username) {
        usernameField.type(username);
    }

    @Override
    public void typePassword(String password) {
        passwordField.type(password);
    }

    @Override
    public void clickLogin() {
        loginButton.click();
    }

    @Override
    public void login(String username, String password) {
        typeUsername(username);
        typePassword(password);
        clickLogin();
    }
}