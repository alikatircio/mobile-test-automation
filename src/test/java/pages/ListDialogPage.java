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
import utils.SeleniumHelper;

import java.time.Duration;
import java.util.List;

public class ListDialogPage {

    AndroidDriver driver;

    @AndroidFindBy(accessibility = "App")
    WebElement appMenu;

    @AndroidFindBy(accessibility = "Alert Dialogs")
    WebElement alertDialogsMenu;

    @AndroidFindBy(accessibility = "List dialog")
    WebElement listDialogMenu;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/text1']")
    List<WebElement> listItems;
    @AndroidFindBy(id = "android:id/message")
    WebElement alertMessage;
    public ListDialogPage (AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(appMenu));
    }

    public void navigateToListDialog() {
        appMenu.click();
        alertDialogsMenu.click();
        listDialogMenu.click();
        LogUtils.logInfo("Navigate to the list dialog menu");

    }
    public void selectRandomElementAndVerify() {

        int index = SeleniumHelper.getRandomIndex(listItems);
        String message = listItems.get(index).getText();
        listItems.get(index).click();

        LogUtils.logInfo("Verifying message: You selected: " + index + ", " + message);
        String expectedMessage = "You selected: " + index + " , " + message;
        AssertionHelper.verifyElementText(alertMessage.getText(), expectedMessage);

    }
}
