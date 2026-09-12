package com.solvd.carina.demo.mobile.gui.pages.ios;

import org.openqa.selenium.WebDriver;

import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;

@DeviceType(
		pageType = Type.IOS_PHONE,
		parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void typeUsername(String username) {
	}

	@Override
	public void typePassword(String password) {
	}

	@Override
	public void clickLogin() {
	}

	@Override
	public void login(String username, String password) {
	}
}
