package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import ge.tbc.testautomation.pages.HomePage;

public class HomeSteps extends BaseSteps {
    HomePage homePage;

    public HomeSteps(Page page) {
        super(page);
        this.homePage = new HomePage(page);
    }

    public void goToAtmAndBranches() {
        homePage.locationsLink.click();
    }

}
