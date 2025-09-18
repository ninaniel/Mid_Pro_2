package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.WaitForSelectorState;
import ge.tbc.testautomation.pages.BasePage;

public class BaseSteps {
    Page page;
    BasePage basePage;

    public BaseSteps(Page page) {
        this.page = page;
        this.basePage = new BasePage(page);
    }

    public void acceptCookiesIfRequested() {
//        if (basePage.cookieAcceptBtn.isVisible()) {
//            basePage.cookieAcceptBtn.click();
//        }
        basePage.cookieAcceptBtn.click();
    }

    public BaseSteps openNavBar() {
        basePage.navItemPersonal.hover();
        return this;
    }

    public BaseSteps verifyNavItemsAppeared() {
        PlaywrightAssertions.assertThat(basePage.navSubItems).not().hasCount(0);
        return this;
    }

    public void navigateToLoans() {
        basePage.loansBtn.click();
    }


}
