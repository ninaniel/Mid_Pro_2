package ge.tbc.testautomation.runners;

import com.microsoft.playwright.*;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.steps.BaseSteps;
import org.testng.annotations.BeforeClass;

import java.util.Arrays;

public class BaseTest {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    protected Page page;
    BaseSteps baseSteps;

    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setArgs(Arrays.asList("--no-sandbox", "--disable-gpu", "--disable-extensions"));
        launchOptions.setHeadless(false);
        launchOptions.setSlowMo(1000);
        browser = playwright.chromium().launch(launchOptions);
        browserContext = createContext();
        page = browserContext.newPage();
        this.baseSteps = new BaseSteps(page);

        page.navigate(Constants.BASE_URL);
        baseSteps.acceptCookiesIfRequested();
    }

    protected BrowserContext createContext() {
        return browser.newContext();
    }
}
