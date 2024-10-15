package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class WaitHelper {

    static final int TIMEOUT = 30;
    static final int POLLING = 3;

    public static void fluentWaitForElementPresence(AndroidDriver driver, By by) {
        FluentWait<AndroidDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(TIMEOUT))
                .pollingEvery(Duration.ofSeconds(POLLING))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    public static void fluentWaitForElementVisible(AndroidDriver driver, WebElement element) {
        FluentWait<AndroidDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(TIMEOUT))
                .pollingEvery(Duration.ofSeconds(POLLING))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(
                ExpectedConditions.visibilityOf(element)
        );
    }

}
