package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HideShowPage;
import utils.LogUtils;

public class HideShowTest extends BaseTest {

    @Test
    public void testHideShow() {

        String scenarioName = "Test Hide and Show";
        LogUtils.logInfo("Starting scenario: " + scenarioName);
        HideShowPage hideShowPage = new HideShowPage(driver);
        hideShowPage.navigateToHideShow();
        hideShowPage.clickHideOrShowButtons();
        hideShowPage.verifyTextBoxesAreDisabled();
        hideShowPage.clickHideOrShowButtons();
        hideShowPage.verifyTextBoxesAreEnabled();
    }
}
