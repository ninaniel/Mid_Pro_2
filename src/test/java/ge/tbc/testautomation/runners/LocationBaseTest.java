package ge.tbc.testautomation.runners;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.options.Geolocation;
import ge.tbc.testautomation.data.Constants;

import java.util.List;

public class LocationBaseTest extends BaseTest {
    @Override
    protected BrowserContext createContext() {
        return browser.newContext(new Browser.NewContextOptions()
                .setGeolocation(new Geolocation(Constants.TBILISI_LAT, Constants.TBILISI_LON)) // Example: Tbilisi
                .setPermissions(List.of("geolocation"))
        );
    }
}