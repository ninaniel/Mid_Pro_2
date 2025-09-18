package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.WaitForSelectorState;
import ge.tbc.testautomation.pages.ConcreteAutoLoanPage;
import ge.tbc.testautomation.utils.TextParser;
import org.testng.Assert;

public class ConcreteAutoLoanSteps extends BaseSteps {
    ConcreteAutoLoanPage loanPage;

    public ConcreteAutoLoanSteps(Page page) {
        super(page);
        this.loanPage = new ConcreteAutoLoanPage(page);
    }

    public ConcreteAutoLoanSteps ensurePageOpenedCorrectOffer(String text) {
        PlaywrightAssertions.assertThat(loanPage.loanTitle).hasText(text);
        return this;
    }

    public ConcreteAutoLoanSteps verifyLoanDetailsAreVisible(){
        PlaywrightAssertions.assertThat(loanPage.detailsContainer).isVisible();
        return this;
    }
    public ConcreteAutoLoanSteps openTermsTab() {
        loanPage.termsBtn.click();
        return this;
    }

    public ConcreteAutoLoanSteps verifyTermsAppeared() {
        loanPage.termsContainer.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        PlaywrightAssertions.assertThat(loanPage.termsRows).not().hasCount(0);
        return this;
    }

    public ConcreteAutoLoanSteps verifyEachConditionHasTitle() {
        int count = loanPage.termsRows.count();
        for (int i=0; i<count; i++) {
            PlaywrightAssertions.assertThat(loanPage.termTitle.nth(i)).isVisible();
            Assert.assertFalse(loanPage.termTitle.nth(i).innerText().isEmpty());
        }
        return this;
    }

    public ConcreteAutoLoanSteps verifyEachConditionHasDescription() {
        int count = loanPage.termsRows.count();
        for (int i=0; i<count; i++) {
            PlaywrightAssertions.assertThat(loanPage.termDescription.nth(i)).isVisible();
            Assert.assertFalse(loanPage.termDescription.nth(i).innerText().isEmpty());
        }
        return this;
    }

    public ConcreteAutoLoanSteps openCalculator() {
        loanPage.loansCalculatorBtn.click();
        return this;
    }

    public ConcreteAutoLoanSteps verifyCalculatorIsVisible() {
        PlaywrightAssertions.assertThat(loanPage.calculator).isVisible();
        return this;
    }

    public ConcreteAutoLoanSteps selectLoanCurrency(String cur) {
        loanPage.currencyBtn.getByText(cur).click();
        return this;
    }

    public ConcreteAutoLoanSteps inputLoanAmount(String amount) {
        loanPage.inputDiv.first().click();
        for (int i = 0; i < 6; i++) {
            page.keyboard().press("Backspace");
        }
        page.keyboard().type(amount);
        return this;
    }

    public ConcreteAutoLoanSteps setLoanPeriod(String period) {
        loanPage.sliderText.getByText(period).click();
        return this;
    }

    public ConcreteAutoLoanSteps verifyMonthlyContributionAmountIsDisplayed() {
        PlaywrightAssertions.assertThat(loanPage.monthlyContributionAmount).not().hasCount(0);
        int count = loanPage.monthlyContributionAmount.count();
        for (int i = 0; i < count; i++) {
            PlaywrightAssertions.assertThat(loanPage.monthlyContributionAmount.nth(i)).isVisible();
        }
        return this;
    }

    public ConcreteAutoLoanSteps verifyDisplayedLoanAmount(String amount) {
        String amountDisplayed = TextParser.getNumber(loanPage.amount.innerText());
        Assert.assertEquals(amountDisplayed,amount);
        return this;
    }

    public ConcreteAutoLoanSteps verifyDisplayedLoanPeriod(String period) {
        String displayedPeriod = TextParser.getNumber(loanPage.period.innerText());
        Assert.assertEquals(displayedPeriod,period);
        return this;
    }

    public ConcreteAutoLoanSteps verifyDisplayedLoanCurrency(String currency) {
        String currencyDisplayed = TextParser.getCurrency(loanPage.amount.innerText());
        Assert.assertEquals(currencyDisplayed,currency);
        return this;
    }

    public ConcreteAutoLoanSteps applyForLoan() {
        loanPage.applyBtn.click();
        return this;
    }

    public ConcreteAutoLoanSteps verifySidebarAppeared() {
        loanPage.sidebar.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        return this;
    }

    public ConcreteAutoLoanSteps verifySideBarTitle(String sidebarTitle) {
        PlaywrightAssertions.assertThat(loanPage.sidebarTitle).hasText(sidebarTitle);
        return this;
    }

    public ConcreteAutoLoanSteps verifyRequestFormExists() {
        PlaywrightAssertions.assertThat(loanPage.requestForm).isVisible();
        return this;
    }

    public ConcreteAutoLoanSteps fillname(String name) {
        loanPage.nameField.click();
        page.keyboard().type(name);
        return this;
    }

    public ConcreteAutoLoanSteps fillIdNumber(String id) {
        loanPage.idField.click();
        page.keyboard().type(id);
        return this;
    }

    public  ConcreteAutoLoanSteps fillPhoneNumber(String num) {
        loanPage.phoneNumField.click();
        page.keyboard().type(num);
        return this;
    }

    public ConcreteAutoLoanSteps verifyNoErrorMsgVisible() {
        PlaywrightAssertions.assertThat(loanPage.errorMsg).not().isVisible();
        return this;
    }

}
