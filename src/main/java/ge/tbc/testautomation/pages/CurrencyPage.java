package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CurrencyPage {
    public Locator currencyPageTitle;
    public Locator popularCurrenciesWrapper;
    public Locator popularCurrencies;
    public Locator popCurrency;
    public Locator dropdownFrom;
    public Locator dropdownTo;
    public Locator currencyList;
    public Locator calculator;
    public Locator rateOnCalculator;
    public Locator reverseButton;
    public Locator currencyName;
    public Locator sellBuyRate;
    public Locator amountInput;

    public CurrencyPage(Page page) {
        this.currencyPageTitle = page.locator(".tbcx-pw-popular-currencies .tbcx-pw-popular-currencies__main-title");
        this.popularCurrenciesWrapper = page.locator(".tbcx-pw-popular-currencies .tbcx-pw-popular-currencies__rows");
        this.popularCurrencies = popularCurrenciesWrapper.locator(".tbcx-pw-popular-currencies__row");
        this.currencyName = popularCurrenciesWrapper.locator("tbcx-pw-currency-badge");
        this.dropdownFrom = page.locator(".tbcx-dropdown-selector .tbcx-selection-text").first();
        this.dropdownTo = page.locator(".tbcx-dropdown-selector .tbcx-selection-text").last();
        this.currencyList = page.locator(".tbcx-item-list .tbcx-dropdown-popover-item");
        this.calculator = page.locator(".exchange-rates-calculator tbcx-pw-exchange-rates-calculator");
        this.rateOnCalculator = page.locator(".tbcx-pw-exchange-rates-calculator__description");
        this.reverseButton = page.locator(".tbcx-pw-exchange-rates-calculator__swap button");

    }

    public void getCurrencyDetails(int index) {
        this.popCurrency = popularCurrencies.nth(index);
    }

    public void getSellOrBuyRate(String text) {
        this.sellBuyRate = popCurrency
                .locator(".tbcx-pw-popular-currencies__caption")
                .getByText(text, new Locator.GetByTextOptions().setExact(true))
                .locator("+ .tbcx-pw-popular-currencies__body");
    }

    public void selectAmountInput() {
        this.amountInput = dropdownFrom.locator("xpath=ancestor::div[contains(@class,'tbcx-text-input')]");
    }

}

