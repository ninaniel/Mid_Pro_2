package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoansPage {
    public Locator loansSections;
    public Locator autoLoansSection;
    public Locator openDetailsBtn;

    public LoansPage(Page page){
        this.loansSections = page.locator(".tbcx-pw-container .tbcx-pw-cta-section__content");
        this.autoLoansSection = page.locator("h1").getByText(" ავტო სესხი ");
        this.openDetailsBtn = page.locator("a[href='/ka/loans/auto-loan']");

    }
}


// public Locator getByAttribute(String tag, String attribute, String value) {
//    return page.locator(tag + "[" + attribute + "='" + value + "']");
//}
//
// // Usage:
//Locator autoLoanLink = getByAttribute("a", "href", "/ka/loans/auto-loan");
