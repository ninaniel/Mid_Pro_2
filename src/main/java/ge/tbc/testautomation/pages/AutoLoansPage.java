package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;


public class AutoLoansPage {
    public Locator offers;
    public Locator loansSectionTitles;
    public Locator openTermsBtn;

    public AutoLoansPage(Page page) {
        this.offers = page.locator(".components-group app-cta-section");
        this.loansSectionTitles = page.locator(".components-group app-cta-section h1");
        this.openTermsBtn = page.locator(".components-group button").getByText("პირობები");
    }
}
