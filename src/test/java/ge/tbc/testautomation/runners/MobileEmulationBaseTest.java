package ge.tbc.testautomation.runners;

import com.microsoft.playwright.*;

public class MobileEmulationBaseTest extends BaseTest {

    // default - iPhone
    protected String deviceName = "iPhone";

    @Override
    protected BrowserContext createContext() {
        Browser.NewContextOptions options;

        switch (deviceName.toLowerCase()) {
            case "pixel":
                options = new Browser.NewContextOptions()
                        .setViewportSize(393, 851)
                        .setDeviceScaleFactor(2.75)
                        .setIsMobile(true)
                        .setHasTouch(true)
                        .setUserAgent("Mozilla/5.0 (Linux; Android 11; Pixel 5) " +
                                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.71 Mobile Safari/537.36");
                break;

            case "iphone":
            default:
                options = new Browser.NewContextOptions()
                        .setViewportSize(390, 844)
                        .setDeviceScaleFactor(3)
                        .setIsMobile(true)
                        .setHasTouch(true)
                        .setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 14_0 like Mac OS X) " +
                                "AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0 Mobile/15E148 Safari/604.1");
                break;
        }

        return browser.newContext(options);
    }
}
