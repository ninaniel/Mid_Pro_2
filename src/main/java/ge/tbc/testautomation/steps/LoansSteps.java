package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import ge.tbc.testautomation.pages.LoansPage;

import java.util.regex.Pattern;

public class LoansSteps extends BaseSteps {
    LoansPage loansPage;

    public  LoansSteps(Page page) {
        super(page);
        this.loansPage = new LoansPage(page);
    }

    public LoansSteps ensurePageNavigatedToLoans(String url) {
        PlaywrightAssertions.assertThat(page).hasURL(Pattern.compile(url));
        return this;
    }

    public LoansSteps verifyLoansSectionNotEmpty() {
        PlaywrightAssertions.assertThat(loansPage.loansSections).not().hasCount(0);
        return this;
    }

    public LoansSteps scrollToAutoLoansSection() {
        loansPage.autoLoansSection.hover();
        return this;
    }

    public void goToAutoLoans() {
        loansPage.openDetailsBtn.click();
    }


}
