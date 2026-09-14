package com.solvd.carina.demo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.SkipException;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.solvd.carina.demo.mobile.gui.pages.ios.PreferencesPage;
import com.solvd.carina.demo.utils.MobileContextUtils;
import com.zebrunner.carina.utils.mobile.IMobileUtils;

import io.appium.java_client.InteractsWithApps;

public class IOSPreferencesTest implements IAbstractTest, IMobileUtils {
    
    @Test
    public void nativePreferencesTest() {
        R.CONFIG.put("capabilities.platformName", "iOS", true);
        R.CONFIG.put("capabilities.automationName", "XCUITest", true);
        String _app = R.CONFIG.get("capabilities.app");
        String _bundle = R.CONFIG.get("capabilities.bundleId");
        if ((_app == null || _app.isEmpty()) && (_bundle == null || _bundle.isEmpty())) {
            throw new SkipException("No iOS app or bundleId configured (capabilities.app or capabilities.bundleId). Skipping iOS Preferences test.");
        }
        WebDriver driver = getDriver();
        MobileContextUtils contextUtils = new MobileContextUtils();
        ((InteractsWithApps) contextUtils.getPureDriver(driver)).activateApp("com.apple.Preferences");
        PreferencesPage preferencesPage = new PreferencesPage(driver);
        preferencesPage.clickGeneralBtn();
        driver.navigate().back();
    }

}
