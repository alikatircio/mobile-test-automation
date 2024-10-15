package utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class SeleniumHelper {

    public static void enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public static int getRandomIndex(List<?> list) {
        Random random = new Random();
        return random.nextInt(list.size());
    }

    public static void longPressElement(AppiumDriver driver, WebElement element) {

        new Actions(driver).clickAndHold(element).perform();
        LogUtils.logInfo("Long pressing the button");
    }

    public static void scrollAndClick(AppiumDriver driver, String visibleText) {
        driver.findElement(AppiumBy.
                androidUIAutomator(
                        "new UiScrollable(" +
                                "new UiSelector()" +
                                ".scrollable(true)" +
                                ".instance(0))" +
                                ".scrollIntoView(" +
                                "new UiSelector()" +
                                ".textContains(\""+visibleText+"\")" +
                                ".instance(0))")
                ).click();
        LogUtils.logInfo("Scrolling and clicking on the element");
    }

    public static void horizontalScrollAndClick(AppiumDriver driver, String visibleText) {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()" +
                        ".scrollable(true)" +
                        ".instance(0))" +
                        ".setAsHorizontalList()" +
                        ".scrollIntoView(new UiSelector()" +
                        ".text(\"" + visibleText + "\"))"
        ));
        WebElement tabToClick = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"" + visibleText + "\")"
        ));
        if (tabToClick.isDisplayed()) {
            tabToClick.click();
        } else {
            throw new RuntimeException("The target tab is not visible for clicking");
        }
        LogUtils.logInfo("Performing a horizontal scroll and clicking on the element");
    }
}
