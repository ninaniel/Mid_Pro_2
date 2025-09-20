package ge.tbc.testautomation.utils;

import com.microsoft.playwright.Locator;
import org.testng.Assert;

import java.util.regex.Pattern;

public class CustomCss {

    public static void assertIsSelected(Locator element) {
        Assert.assertTrue(element.getAttribute("class").contains("active"));
    }
}
