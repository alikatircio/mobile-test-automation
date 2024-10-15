package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AssertionHelper;
import utils.LogUtils;

import java.time.Duration;
import java.util.List;

public class HideShowPage {

    enum ButtonState {
        HIDE("Hide"),
        SHOW("Show");

        private final String text;

        ButtonState(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
    AndroidDriver driver;

    @AndroidFindBy(accessibility = "App")
    WebElement appMenu;

    @AndroidFindBy(accessibility = "Fragment")
    WebElement fragmentMenu;

    @AndroidFindBy(accessibility = "Hide and Show")
    WebElement hideShowMenu;
    @AndroidFindAll({
            @AndroidBy(id = "io.appium.android.apis:id/frag1hide"),
            @AndroidBy(id = "io.appium.android.apis:id/frag2hide")
    })
    List<WebElement> hideButtons;
    @AndroidFindAll({
            @AndroidBy(id = "io.appium.android.apis:id/fragment1"),
            @AndroidBy(id = "io.appium.android.apis:id/fragment2")
    })
    List<WebElement> textBoxes;

    public HideShowPage (AndroidDriver driver) {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(appMenu));
    }
    public void navigateToHideShow() {
        appMenu.click();
        fragmentMenu.click();
        hideShowMenu.click();
        LogUtils.logInfo("Navigate to the hide show menu");
    }

    public void clickHideOrShowButtons() {

        for (WebElement element : hideButtons){

            element.click();
            LogUtils.logInfo("Clicked the show/hide buttons");
        }
    }

    public void verifyTextBoxesState(ButtonState state, List<WebElement> textBoxes, List<WebElement> buttons) {
        for (int i = 0; i < textBoxes.size(); i++) {
            WebElement textBox = textBoxes.get(i);
            WebElement button = buttons.get(i);

            switch (state) {
                case HIDE -> {
                    AssertionHelper.verifyAssertTrue(textBox.isDisplayed());
                    AssertionHelper.verifyElementText(button.getText(), ButtonState.HIDE.getText());
                    LogUtils.logInfo("Verifying the textBox status and the button text");
                }
                case SHOW -> {
                    AssertionHelper.verifyAssertFalse(textBox.isDisplayed());
                    AssertionHelper.verifyElementText(button.getText(), ButtonState.SHOW.getText());
                    LogUtils.logInfo("Verifying the textBox status and the button text");
                }
                default -> throw new IllegalArgumentException("Invalid ButtonState");
            }
        }
    }

    public void verifyTextBoxesAreDisabled() {

        verifyTextBoxesState(ButtonState.SHOW, textBoxes, hideButtons);
    }

    public void verifyTextBoxesAreEnabled() {
        verifyTextBoxesState(ButtonState.HIDE, textBoxes, hideButtons);
    }
}
