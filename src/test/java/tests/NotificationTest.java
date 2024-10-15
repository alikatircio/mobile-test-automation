package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.NotificationPage;
import utils.LogUtils;

public class NotificationTest extends BaseTest {

    @Test
    public void testNotification() {

        String scenarioName = "Test Notification";
        LogUtils.logInfo("Starting scenario: " + scenarioName);
        NotificationPage notificationPage = new NotificationPage(driver);
        notificationPage.navigateToIncomingMessage();
        notificationPage.clickShowNotification();
        notificationPage.openNotifications();
        notificationPage.checkAndClickNotification();
        notificationPage.verifyNotificationText();
    }
}
