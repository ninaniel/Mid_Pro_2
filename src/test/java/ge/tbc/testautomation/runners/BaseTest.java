package ge.tbc.testautomation.runners;

import com.microsoft.playwright.*;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.steps.BaseSteps;
import org.testng.annotations.*;

import java.util.Arrays;

public class BaseTest {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    protected Page page;
    protected BaseSteps baseSteps;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        playwright = Playwright.create();
    }

    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("CHROME") String browserName) {
        playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setArgs(Arrays.asList("--no-sandbox", "--disable-gpu", "--disable-extensions"));
        launchOptions.setHeadless(true);
        launchOptions.setSlowMo(1000);

        switch (browserName.toUpperCase()) {
            case "FIREFOX":
                browser = playwright.firefox().launch(launchOptions);
                break;
            case "WEBKIT":
                browser = playwright.webkit().launch(launchOptions);
                break;
            case "CHROME":
            default:
                browser = playwright.chromium().launch(launchOptions);
                break;
        }

        browserContext = createContext();
        page = browserContext.newPage();
        this.baseSteps = new BaseSteps(page);

        page.navigate(Constants.BASE_URL);
        baseSteps.acceptCookiesIfRequested();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        if (browserContext != null) browserContext.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        if (playwright != null) playwright.close();
    }


    protected BrowserContext createContext() {
        return browser.newContext();
    }
}
