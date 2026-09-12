package com.solvd.carina.demo.mobile.gui.pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.demo.mobile.gui.pages.common.CheckoutCompletePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(
        pageType = Type.ANDROID_PHONE,
        parentClass = CheckoutCompletePageBase.class)
public class CheckoutCompletePage extends CheckoutCompletePageBase {

    @FindBy(xpath = "//*[@text='CHECKOUT: COMPLETE!']")
    private ExtendedWebElement title;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return title.isElementPresent();
    }
}