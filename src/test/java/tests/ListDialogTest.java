package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ListDialogPage;
import utils.LogUtils;

public class ListDialogTest extends BaseTest {

    @Test
    public void testListDialog() {

        String scenarioName = "Test List Dialog";
        LogUtils.logInfo("Starting scenario: " + scenarioName);
        ListDialogPage listDialogPage = new ListDialogPage(driver);
        listDialogPage.navigateToListDialog();
        listDialogPage.selectRandomElementAndVerify();
    }
}
