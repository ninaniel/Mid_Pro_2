package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;


public class HomePage {
    public Locator locationsLink;


    public HomePage(Page page) {
        this.locationsLink = page.locator(".pane-container a[href='/ka/atms&branches']");

    }
}

//locationsNavLink()  $("      tbcx-pw-contacts a[href='/ka/atms&branches']");

