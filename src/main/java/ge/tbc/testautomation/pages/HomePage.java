package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;


public class HomePage {
    public Locator locationsLink;
    public Locator currencyExchange;


    public HomePage(Page page) {
        this.locationsLink = page.locator(".pane-container a[href='/ka/atms&branches']");
        this.currencyExchange = page.locator(".pane-container a[href='/ka/treasury-products']");

    }
}


