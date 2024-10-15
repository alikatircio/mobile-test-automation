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

import java.time.Duration;

public class TabsPage {

    AndroidDriver driver;

    static final String CONTENT_EXP_TEXT = "Content for tab with tag Tab 30";
    @AndroidFindBy(accessibility = "Views")
    WebElement viewsMenu;
    @AndroidFindBy(accessibility = "5. Scrollable")
    WebElement scrollableMenu;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Content for tab with tag')]")
    WebElement content;

    public TabsPage (AndroidDriver driver) {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(viewsMenu));
    }

    public void navigateToScrollableTabs() {
        viewsMenu.click();
        SeleniumHelper.scrollAndClick(driver, "Tabs");
        scrollableMenu.click();
        LogUtils.logInfo("Navigate to the scrollable menu");

    }

    public void clickTab30() {
        SeleniumHelper.horizontalScrollAndClick(driver, "TAB 30");
    }

    public void verifyContent() {

        LogUtils.logInfo("Verifying the opened content");
        AssertionHelper.verifyElementText(content.getText(), CONTENT_EXP_TEXT);
    }
}
