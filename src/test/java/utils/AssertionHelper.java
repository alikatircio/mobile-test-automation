package utils;

import org.testng.Assert;

public class AssertionHelper {

    public static void verifyElementText(String actualText, String expectedText) {
        Assert.assertEquals(actualText, expectedText, "Values are not equal act: "+ actualText +" exp: "+ expectedText);
    }

    public static void verifyAssertTrue(boolean flag) {

        Assert.assertTrue(flag, "Value is not true ,"+ flag);
    }

    public static void verifyAssertFalse(boolean flag) {

        Assert.assertFalse(flag, "Value is not true ,"+ flag);
    }
}
