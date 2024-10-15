package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AssertionHelper;
import utils.LogUtils;
import utils.WaitHelper;

import java.time.Duration;

public class NotificationPage {

    AndroidDriver driver;

    static final String NOT_TITLE = "Joe";
    String notText = "";
    @AndroidFindBy(accessibility = "App")
    WebElement appMenu;

    @AndroidFindBy(accessibility = "Notification")
    WebElement notificationMenu;

    @AndroidFindBy(accessibility = "IncomingMessage")
    WebElement incomingMessageMenu;

    @AndroidFindBy(id = "io.appium.android.apis:id/notify_app")
    WebElement showNotificationButton;

    @AndroidFindBy(id = "android:id/title")
    WebElement notificationTitle;
    @AndroidFindBy(id = "android:id/text")
    WebElement notificationText;
    @AndroidFindBy(id =  "io.appium.android.apis:id/from")
    WebElement notificationMessageTitle;
    @AndroidFindBy(id =  "io.appium.android.apis:id/message")
    WebElement notificationMessageText;

    public NotificationPage (AndroidDriver driver) {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(appMenu));
    }

    public void navigateToIncomingMessage() {
        appMenu.click();
        notificationMenu.click();
        incomingMessageMenu.click();
        LogUtils.logInfo("Navigate to the incoming message menu");

    }

    public void clickShowNotification() {

        showNotificationButton.click();
        LogUtils.logInfo("Clicked the 'Show Notification' button");
    }

    public void openNotifications() {

        driver.openNotifications();
        LogUtils.logInfo("Opened the notification");

    }

    public void checkAndClickNotification() {

        WaitHelper.fluentWaitForElementVisible(driver, notificationTitle);
        AssertionHelper.verifyAssertTrue(notificationTitle.isDisplayed());
        AssertionHelper.verifyAssertTrue(notificationText.isDisplayed());
        AssertionHelper.verifyElementText(notificationTitle.getText(), NOT_TITLE);
        notText = notificationText.getText();
        notificationTitle.click();
        LogUtils.logInfo("Opened the notification message");

    }

    public void verifyNotificationText() {

        LogUtils.logInfo("Verifying the opened notification");
        AssertionHelper.verifyElementText(notificationMessageTitle.getText(), NOT_TITLE);
        AssertionHelper.verifyElementText(notificationMessageText.getText(), notText);
    }
}
