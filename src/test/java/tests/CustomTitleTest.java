package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CustomTitlePage;
import utils.LogUtils;

public class CustomTitleTest extends BaseTest {

    @Test
    public void testCustomTitle() {

        String scenarioName = "Test Custom Title";
        LogUtils.logInfo("Starting scenario: " + scenarioName);
        CustomTitlePage customTitlePage = new CustomTitlePage(driver);
        customTitlePage.navigateToCustomTitle();
        customTitlePage.checkNavBarAndText();
        customTitlePage.changeLeftAndRightBarText();
    }
}
