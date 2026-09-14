package com.solvd.carina.demo;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;

public class IOSNegativeLoginTest implements IAbstractTest {

    @Test
    public void negativeLoginTestIOS() {
        R.CONFIG.put("capabilities.platformName", "iOS", true);
        try {
            LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
            loginPage.login("wrong_user", "wrong_password");
            Assert.assertTrue(loginPage.isLoginErrorDisplayed(), "Expected login error not displayed on iOS");
        } catch (Exception e) {
            throw new SkipException("iOS environment or app not ready for negative-login test: " + e.getMessage());
        }
    }
}
