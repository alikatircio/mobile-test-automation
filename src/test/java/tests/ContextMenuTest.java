package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ContextMenuPage;
import utils.AssertionHelper;
import utils.LogUtils;

public class ContextMenuTest extends BaseTest {

    @Test
    public void testContextMenu() {

        String scenarioName = "Test Context Menu";
        LogUtils.logInfo("Starting scenario: " + scenarioName);
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.navigateToContextMenu();
        contextMenuPage.longPressButton();
        contextMenuPage.verifyMenuAVisible();
        contextMenuPage.verifyMenuBVisible();
    }


}
