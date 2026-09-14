package com.solvd.carina.demo.mobile.gui.pages.ios;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public class DragAndDropPage extends AbstractPage implements IMobileUtils {

    @FindBy(xpath = "//*[@name='drag_dot_1']")
    private ExtendedWebElement target;

    @FindBy(xpath = "//*[@name='drag_dot_2']")
    private ExtendedWebElement rightDestination;

    @FindBy(xpath = "//*[@name='drag_dot_3']")
    private ExtendedWebElement downDestination;

    @FindBy(xpath = "//*[@name='drag_dot_hidden']")
    private ExtendedWebElement diagonalDestination;

    @FindBy(xpath = "//*[@name='drag_text']")
    private ExtendedWebElement dragAndDropMessage;

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public void dragRight() {
        try {
            dragAndDrop(target, rightDestination, Duration.ofSeconds(2), Duration.ofSeconds(3));
        } catch (Exception e) {
            // fallback: try dragging by coordinates if elements not found
            dragByOffset(100, 0);
        }
    }

    public void dragDown() {
        try {
            dragAndDrop(target, downDestination, Duration.ofSeconds(2), Duration.ofSeconds(3));
        } catch (Exception e) {
            dragByOffset(0, 100);
        }
    }

    public void dragDiagonal() {
        try {
            dragAndDrop(target, diagonalDestination, Duration.ofSeconds(2), Duration.ofSeconds(3));
        } catch (Exception e) {
            dragByOffset(75, 75);
        }
    }

    public boolean isDragAndDropMessagePresent(){
        try {
            return dragAndDropMessage.isElementPresent(2) && !dragAndDropMessage.getText().isBlank();
        } catch (Exception e) {
            return false;
        }
    }

    // simple coordinate drag fallback using IMobileUtils
    private void dragByOffset(int xOffset, int yOffset) {
        try {
            // attempt to use target element center as start
            if (target != null && target.isElementPresent(1)) {
                int startX = target.getLocation().getX();
                int startY = target.getLocation().getY();
                swipe(startX, startY, startX + xOffset, startY + yOffset, 1000);
            }
        } catch (Exception ignored) {
        }
    }
}
