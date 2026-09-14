package com.solvd.carina.demo;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;

public class IOSDragAndDropTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testDragAndDropIOS() {
        R.CONFIG.put("capabilities.platformName", "iOS", true);
        R.CONFIG.put("capabilities.automationName", "XCUITest", true);
        String _app = R.CONFIG.get("capabilities.app");
        String _bundle = R.CONFIG.get("capabilities.bundleId");
        if ((_app == null || _app.isEmpty()) && (_bundle == null || _bundle.isEmpty())) {
            throw new SkipException("No iOS app or bundleId configured (capabilities.app or capabilities.bundleId). Skipping iOS drag-and-drop test.");
        }
        // prefer to reuse platform-specific page if exists
        try {
            Class<?> pageClass = Class.forName("com.solvd.carina.demo.mobile.gui.pages.ios.DragAndDropPage");
            Object page = pageClass.getConstructor(org.openqa.selenium.WebDriver.class).newInstance(getDriver());
            // try to invoke same methods as android page
            pageClass.getMethod("dragDown").invoke(page);
            pageClass.getMethod("dragRight").invoke(page);
            pageClass.getMethod("dragDiagonal").invoke(page);
            Boolean present = (Boolean) pageClass.getMethod("isDragAndDropMessagePresent").invoke(page);
            Assert.assertTrue(present, "Should be provided pop up message after successful drag and drop (iOS)");
        } catch (ClassNotFoundException e) {
            throw new SkipException("iOS DragAndDropPage is not implemented. Create com.solvd.carina.demo.mobile.gui.pages.ios.DragAndDropPage to enable this test.");
        } catch (org.testng.SkipException se) {
            throw se;
        } catch (Exception e) {
            // set capabilities for iOS app if needed and fail with details
            R.CONFIG.put("capabilities.platformName", "iOS", true);
            throw new RuntimeException("Failed to run iOS drag and drop test: " + e.getMessage(), e);
        }
    }
}
