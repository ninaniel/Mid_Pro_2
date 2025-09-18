package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ConcreteAutoLoanPage {
    public Page page;
    public Locator loanTitle;
    public Locator detailsContainer;
    // terms
    public Locator termsBtn;
    public Locator termsContainer;
    public Locator termsRows;
    public Locator termTitle;
    public Locator termDescription;
    //calculator
    public Locator loansCalculatorBtn;
    public Locator calculator;
    public Locator monthlyContributionAmount;
    public Locator detailsRows;
    public Locator amountField;
    public Locator amount;
    public Locator periodField;
    public Locator period;
    public Locator inputDiv;
    public Locator currencyBtn;
    public Locator sliderText;
    public Locator applyBtn;
    // sidebar to request call
    public Locator sidebar;
    public Locator sidebarTitle;
    public Locator requestForm;
    public Locator nameField;
    public Locator idField;
    public Locator phoneNumField;
    public Locator submitFormBtn;
    public Locator errorMsg;

    public ConcreteAutoLoanPage(Page page) {
        this.page = page;
        this.loanTitle = page.locator(" h1.tbcx-pw-title");
        // tbcx-pw-details-list__item
        this.termsBtn = page.locator(".tbcx-pw-tab-menu__item").getByText("პირობები");
        this.termsContainer = page.locator("app-details-list .tbcx-pw-details-list");
        this.termsRows = termsContainer.locator(".tbcx-pw-details-list__item");
        this.termTitle = termsContainer.locator(".tbcx-pw-details-list__item-caption");
        this.termDescription = termsContainer.locator(".tbcx-pw-details-list__item-title");

        this.loansCalculatorBtn = page.locator(".tbcx-pw-tab-menu__item").getByText("კალკულატორი");
        this.detailsContainer = page.locator("app-tabs-section");
        this.calculator = page.locator("tbcx-pw-calculator .tbcx-pw-calculator");
        this.monthlyContributionAmount = page.locator(".tbcx-pw-calculated-info__top .tbcx-pw-calculated-info__number--new span");
        this.detailsRows = page.locator(".tbcx-pw-calculated-info__rows-item-col").filter(new Locator.FilterOptions()
                        .setHas(page.locator("div.tbcx-pw-calculated-info__alert")));
        this.amountField = detailsRows.filter(new Locator.FilterOptions().setHasText(" სესხის თანხა "));
        this.amount = amountField.locator(".tbcx-pw-calculated-info__rows-item-info");
        this.periodField = detailsRows.filter(new Locator.FilterOptions().setHasText(" სესხის ვადა  "));
        this.period = periodField.locator(".tbcx-pw-calculated-info__rows-item-info");
        this.inputDiv = page.locator("tbcx-text-input .input-with-label");
        this.currencyBtn = page.locator("button.tbcx-pw-calculator-form__currency");//.getByText(" USD ");
        this.sliderText = page.locator(".slider-divider-text");
        this.applyBtn = page.locator("tbcx-pw-calculator button.primary");
        this.sidebar = page.locator(".cdk-overlay-container .tbcx-pw-dialog__overlay--sidebar");
        this.sidebarTitle = sidebar.locator(".tbcx-pw-dialog__header-title");
        this.requestForm = sidebar.locator(".app-request__form");
        this.nameField = page.locator("//tbcx-text-input[@formcontrolname='name']");
        this.idField = page.locator("//tbcx-text-input[@formcontrolname='idNumber']");//idNumber
        this.phoneNumField = page.locator("//tbcx-text-input[@formcontrolname='phoneNumber']");

//        this.nameField = sidebar.locator("input").getByPlaceholder("სახელი");
//        this.idField = sidebar.locator("input").getByPlaceholder("პირადი ნომერი");
//        this.phoneNumField = sidebar.locator("input").getByPlaceholder("ტელეფონის ნომერი");
        this.submitFormBtn = sidebar.locator("button[type='submit']");
        this.errorMsg = page.locator("div.description.errored");

    }

}
