package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BasePage {
    public Locator cookiePopup;
    public Locator cookieAcceptBtn;
    public Locator navItemPersonal;
    public Locator navSubItems;
    public Locator loansBtn;

    public Locator footer;

    public BasePage(Page page) {
        this.cookiePopup = page.locator(".tbcx-pw-cookie-consent .tbcx-pw-cookie-consent");
        this.cookieAcceptBtn = cookiePopup.locator("button.primary");

        this.navItemPersonal = page.locator(".tbcx-pw-navigation-item").getByText(" ჩემთვის ");
        this.navSubItems = page.locator(".tbcx-pw-mega-menu-sub-item--withLink");
        this.loansBtn = page.locator("tbcx-pw-mega-menu-sub-item a[href='/ka/loans']");

        this.footer = page.locator("app-footer");

    }
}
