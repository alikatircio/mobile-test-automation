package base;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverManager;
import utils.LogUtils;

import java.time.Duration;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = DriverManager.initDriver();
        navigateToAppMenu(driver);
    }

    @AfterMethod
    public void tearDown() {

        DriverManager.quitDriver();
    }

    public static void navigateToAppMenu(AndroidDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        boolean appFound = false;
        LogUtils.logInfo("Navigating back to the first page");
        while (!appFound) {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("App")));
                appFound = true;
            } catch (Exception e) {
                driver.navigate().back();
            }
        }
    }
}
