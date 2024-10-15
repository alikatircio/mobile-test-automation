package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AssertionHelper;
import utils.LogUtils;
import utils.SeleniumHelper;
import utils.WaitHelper;

import java.time.Duration;

public class ContextMenuPage {

    AndroidDriver driver;

    @AndroidFindBy(accessibility = "App")
    WebElement appMenu;

    @AndroidFindBy(accessibility = "Fragment")
    WebElement fragmentMenu;

    @AndroidFindBy(accessibility = "Context Menu")
    WebElement contextMenu;

    @AndroidFindBy(id = "io.appium.android.apis:id/long_press")
    WebElement longPressButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Menu A']")
    WebElement menuA;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Menu B']")
    WebElement menuB;

    public ContextMenuPage (AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(appMenu));
    }
    public void navigateToContextMenu() {

        WaitHelper.fluentWaitForElementPresence(driver, AppiumBy.accessibilityId("App"));
        appMenu.click();
        fragmentMenu.click();
        contextMenu.click();
        LogUtils.logInfo("Navigate to the context menu");

    }

    public void longPressButton() {

        SeleniumHelper.longPressElement(driver, longPressButton);
    }

    public void verifyMenuAVisible() {

        LogUtils.logInfo("Checking Menu A is visible");
        AssertionHelper.verifyAssertTrue(menuA.isDisplayed());
    }

    public void verifyMenuBVisible() {

        LogUtils.logInfo("Checking Menu B is visible");
        AssertionHelper.verifyAssertTrue(menuB.isDisplayed());
    }

}
