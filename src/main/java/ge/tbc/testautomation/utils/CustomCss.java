package ge.tbc.testautomation.utils;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import java.util.regex.Pattern;

public class CustomCss {

    public static void assertIsSelected(Locator element) {
        PlaywrightAssertions.assertThat(element).hasClass(Pattern.compile(".*\\bactive\\b.*"));
    }
}
