package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import ge.tbc.testautomation.pages.AutoLoansPage;

import javax.print.DocFlavor;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;

public class AutoLoansSteps extends BaseSteps {
    AutoLoansPage autoLoansPage;
    int randInt;

    public AutoLoansSteps(Page page) {
        super(page);
        this.autoLoansPage = new AutoLoansPage(page);
    }

    public AutoLoansSteps ensurePageNavigatedToAutoLoans(String urlPath) {
        PlaywrightAssertions.assertThat(page).hasURL(Pattern.compile(urlPath));
        return this;
    }

    public AutoLoansSteps verifyOffersExist(){
        PlaywrightAssertions.assertThat(autoLoansPage.offers).not().hasCount(0);
        return this;
    }

    public AutoLoansSteps chooseAnyOffer() {
        int count = autoLoansPage.offers.count();
        this.randInt = ThreadLocalRandom.current().nextInt(0, count);
        autoLoansPage.offers.nth(randInt).hover();
        return this;
    }

    public String getTitle() {
        return autoLoansPage.loansSectionTitles.nth(randInt).innerText().trim();
    }

    public AutoLoansSteps viewTermsAndConditions() {
        autoLoansPage.openTermsBtn.nth(randInt).click();
        return this;
    }
}
