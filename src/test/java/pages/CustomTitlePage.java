package pages;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AssertionHelper;
import utils.LogUtils;
import utils.SeleniumHelper;

import java.time.Duration;


public class CustomTitlePage {

    AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"App\"]")
    WebElement appMenu;
    @AndroidFindBy(accessibility = "Activity")
    WebElement activityMenu;
    @AndroidFindBy(accessibility = "Custom Title")
    WebElement customTitleMenu;
    @AndroidFindBy(id = "io.appium.android.apis:id/left_text")
    WebElement leftNavBar;
    @AndroidFindBy(id = "io.appium.android.apis:id/right_text")
    WebElement rightNavBar;
    @AndroidFindBy(id = "io.appium.android.apis:id/left_text_edit")
    WebElement leftNavTextField;
    @AndroidFindBy(id = "io.appium.android.apis:id/right_text_edit")
    WebElement rightNavTextField;
    @AndroidFindBy(id = "io.appium.android.apis:id/left_text_button")
    WebElement leftChangeBtn;
    @AndroidFindBy(id = "io.appium.android.apis:id/right_text_button")
    WebElement rightChangeBtn;


    public CustomTitlePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(appMenu));
    }

    enum BarType {
        LEFT, RIGHT
    }
    private static final String RIGHT_BAR_CHANGED_TEXT = "Right bar changed";
    private static final String LEFT_BAR_CHANGED_TEXT = "Left bar changed";

    public void navigateToCustomTitle() {

        appMenu.click();
        activityMenu.click();
        customTitleMenu.click();
        LogUtils.logInfo("Navigate to the custom title");
    }

    public void checkNavBarAndText() {

        LogUtils.logInfo("Checking bar text");
        AssertionHelper.verifyElementText(leftNavBar.getText(), leftNavTextField.getText());
        AssertionHelper.verifyElementText(rightNavBar.getText(), rightNavTextField.getText());
    }

    void enterBarText(WebElement element, String text) {

        element.click();
        LogUtils.logInfo("Entering text into the textbox: "+ text);
        SeleniumHelper.enterText(element, text);
    }

    void changeBarText(WebElement element, String text, BarType barType) {

        enterBarText(element, text);

        WebElement buttonToClick;
        WebElement navBar;

        switch (barType) {
            case LEFT -> {
                buttonToClick = leftChangeBtn;
                navBar = leftNavBar;
            }
            case RIGHT -> {
                buttonToClick = rightChangeBtn;
                navBar = rightNavBar;
            }
            default -> throw new IllegalArgumentException("Invalid BarType");
        }

        buttonToClick.click();
        LogUtils.logInfo("Checking the bar text is equal to the expected text");
        AssertionHelper.verifyElementText(navBar.getText(), text);
    }

    public void changeLeftAndRightBarText() {

        changeBarText(leftNavTextField, LEFT_BAR_CHANGED_TEXT, BarType.LEFT);
        changeBarText(rightNavTextField, RIGHT_BAR_CHANGED_TEXT, BarType.RIGHT);
    }

}
