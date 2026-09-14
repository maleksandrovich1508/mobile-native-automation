package com.solvd.carina.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.solvd.carina.demo.mobile.gui.pages.android.DragAndDropPage;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;

public class MobileDragAndDropTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"mobile", "acceptance"})
    public void testDragAndDrop() {
        R.CONFIG.put("capabilities.app",
                "/Users/maksim/carina-automation/mobile-native-automation/mobile-native-automation/src/test/resources/apps/Android-MyDemoAppRN.apk",
                true);
        R.CONFIG.put("capabilities.appActivity", ".view.DragAndDropDemo", true);

        DragAndDropPage dragAndDropPage = new DragAndDropPage(getDriver());
        dragAndDropPage.dragDown();
        dragAndDropPage.dragRight();
        dragAndDropPage.dragDiagonal();
        Assert.assertTrue(dragAndDropPage.isDragAndDropMessagePresent(), "Should be provided pop up message after successful drag and drop");
    }

}
