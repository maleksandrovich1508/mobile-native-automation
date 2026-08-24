package com.solvd.carina.demo;

import org.testng.annotations.Test;

import com.solvd.pages.common.LoginPageBase;
import com.zebrunner.carina.core.IAbstractTest;

public class LoginTest implements IAbstractTest {

    @Test
    public void validLoginTest() {

        LoginPageBase loginPage =
                initPage(getDriver(), LoginPageBase.class);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );
    }
}
