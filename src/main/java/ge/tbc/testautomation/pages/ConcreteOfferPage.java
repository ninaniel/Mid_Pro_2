package ge.tbc.testautomation.pages;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ConcreteOfferPage {
    public Locator offerPageTitle;

    public ConcreteOfferPage(Page page) {
        this.offerPageTitle = page.locator("h2.app-textpage-header__title");
    }
}
