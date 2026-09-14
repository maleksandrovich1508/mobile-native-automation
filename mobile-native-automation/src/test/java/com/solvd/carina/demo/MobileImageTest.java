package com.solvd.carina.demo;

import java.io.InputStream;
import java.util.Base64;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;

public class MobileImageTest implements IAbstractTest {

    @Test
    public void testFindByImage() throws Exception {
        // resource path in src/test/resources/images/sample.png
        InputStream is = getClass().getResourceAsStream("/images/sample.png");
        if (is == null) {
            // No image provided — skip and instruct user how to add one
            throw new SkipException("No sample image found at src/test/resources/images/sample.png. Add an expected image to run this test.");
        }

        byte[] bytes = is.readAllBytes();
        String base64 = Base64.getEncoder().encodeToString(bytes);

        // This requires Appium server with images plugin enabled to handle image locator
        try {
            WebElement el = getDriver().findElement(MobileBy.image(base64));
            // basic assertion to make sure element was found
            if (el == null) {
                throw new AssertionError("Element by image not found");
            }
        } catch (Exception e) {
            // Provide helpful message for debugging
            throw new RuntimeException("Image-based search failed. Ensure Appium images plugin is installed and server is reachable. Original: " + e.getMessage(), e);
        }
    }
}
