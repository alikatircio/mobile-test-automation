package utils;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;


public class DriverManager {

    private static AndroidDriver driver;

    public static AndroidDriver initDriver() {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName(Config.getProperty("platformName"));
        options.setUdid(Config.getProperty("deviceName"));
        options.setApp(Config.getProperty("app"));
        options.setAutomationName("UIAutomator2");
        options.setNoReset(true);

        LogUtils.logInfo("Initializing the driver");

        try {
            driver = new AndroidDriver(new URL(Config.getProperty("appium.server.url")), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    public static AndroidDriver getDriver() {

        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
