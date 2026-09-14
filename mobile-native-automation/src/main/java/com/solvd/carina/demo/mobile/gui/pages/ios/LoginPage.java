package com.solvd.carina.demo.mobile.gui.pages.ios;

import org.openqa.selenium.WebDriver;

import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;

@DeviceType(
		pageType = Type.IOS_PHONE,
		parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

	@org.openqa.selenium.support.FindBy(xpath = "//*[@name='test-Username']")
	private com.zebrunner.carina.webdriver.decorator.ExtendedWebElement usernameField;

	@org.openqa.selenium.support.FindBy(xpath = "//*[@name='test-Password']")
	private com.zebrunner.carina.webdriver.decorator.ExtendedWebElement passwordField;

	@org.openqa.selenium.support.FindBy(xpath = "//*[@name='test-LOGIN']")
	private com.zebrunner.carina.webdriver.decorator.ExtendedWebElement loginButton;

	@org.openqa.selenium.support.FindBy(xpath = "//*[@name='test-Error message']")
	private com.zebrunner.carina.webdriver.decorator.ExtendedWebElement errorMessage;

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

	@Override
	public boolean isErrorMessageDisplayed() {
		try {
		    return errorMessage.isElementPresent(1);
		} catch (Exception e) {
		    return false;
		}
	}
}