package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.TabsPage;
import utils.LogUtils;

public class TabsTest extends BaseTest {

    @Test
    public void testTabs() {

        String scenarioName = "Test Scrollable Tab 30";
        LogUtils.logInfo("Starting scenario: " + scenarioName);
        TabsPage tabsPage = new TabsPage(driver);
        tabsPage.navigateToScrollableTabs();
        tabsPage.clickTab30();
        tabsPage.verifyContent();
    }
}
