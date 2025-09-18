package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.runners.BaseTest;
import ge.tbc.testautomation.steps.AutoLoansSteps;
import ge.tbc.testautomation.steps.ConcreteAutoLoanSteps;
import ge.tbc.testautomation.steps.BaseSteps;
import ge.tbc.testautomation.steps.LoansSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RequestAutoLoanTest extends BaseTest {
    String selectedOfferName;
    BaseSteps baseSteps;
    LoansSteps loansSteps;
    AutoLoansSteps autoLoansSteps;
    ConcreteAutoLoanSteps concreteAutoLoanSteps;

    @BeforeClass
    public void initSteps() {
        this.baseSteps = new BaseSteps(page);
        this.loansSteps = new LoansSteps(page);
        this.autoLoansSteps = new AutoLoansSteps(page);
        this.concreteAutoLoanSteps = new ConcreteAutoLoanSteps(page);
    }

    @Test(priority = 1, description = "step 1")
    public void navigateToLoans() {
        baseSteps
                .openNavBar()
                .verifyNavItemsAppeared()
                .navigateToLoans();
        loansSteps
                .ensurePageNavigatedToLoans(Constants.LOANS_PATH);
    }

    @Test(priority = 2, description = "step 2")
    public void navigateToAutoLoans() {
        loansSteps
                .verifyLoansSectionNotEmpty()
                .scrollToAutoLoansSection()
                .goToAutoLoans();
        autoLoansSteps
                .ensurePageNavigatedToAutoLoans(Constants.AUTO_LOANS_PATH)
                .verifyOffersExist();
    }

    @Test(priority = 3, description = "step 3")
    public void navigateToRandomOffersDetails() {
        autoLoansSteps
                .chooseAnyOffer();

        this.selectedOfferName = autoLoansSteps.getTitle();
        autoLoansSteps
                .viewTermsAndConditions();
        concreteAutoLoanSteps
                .ensurePageOpenedCorrectOffer(selectedOfferName);

    }

    @Test(priority = 4, description = "step 4")
    public void goToTerms() {
        concreteAutoLoanSteps
                .openTermsTab()
                .verifyTermsAppeared()
                .verifyEachConditionHasTitle()
                .verifyEachConditionHasDescription();
    }

    @Test(priority = 5, description = "step 5")
    public void goToLoansCalculator() {
        concreteAutoLoanSteps
                .openCalculator()
                .verifyCalculatorIsVisible()
                .verifyLoanDetailsAreVisible();
    }

    @Test(priority = 6, description = "step 6")
    public void checkLoanDetailsForDesiredAmount() {
        concreteAutoLoanSteps
                .selectLoanCurrency(Constants.CURRENCY_FOR_AUTO_LOAN)
                .inputLoanAmount(Constants.AMOUNT_FOR_AUTO_LOAN)
                .setLoanPeriod(Constants.MONTHS_FOR_AUTO_LOAN)
                .verifyMonthlyContributionAmountIsDisplayed()
                .verifyDisplayedLoanAmount(Constants.AMOUNT_FOR_AUTO_LOAN)
                .verifyDisplayedLoanCurrency(Constants.CURRENCY_SYMBOL_FOR_AUTO_LOAN)
                .verifyDisplayedLoanPeriod(Constants.MONTHS_FOR_AUTO_LOAN);
    }

    @Test(priority = 7, description = "step 7")
    public void applyForLoan() {
        concreteAutoLoanSteps
                .applyForLoan()
                .verifySidebarAppeared()
                .verifySideBarTitle(Constants.SIDEBAR_TITLE)
                .verifyRequestFormExists();
    }

    @Test(priority = 8, description = "step 8")
    public void fillPersonalInformation() {
        concreteAutoLoanSteps
                .fillname(Constants.NAME_FOR_CALL_REQUEST)
                .fillIdNumber(Constants.ID_FOR_CALL_REQUEST)
                .fillPhoneNumber(Constants.PHONE_FOR_CALL_REQUEST)
                .verifyNoErrorMsgVisible();
    }









}
