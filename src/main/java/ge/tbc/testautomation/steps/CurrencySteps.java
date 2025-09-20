package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import ge.tbc.testautomation.pages.CurrencyPage;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static ge.tbc.testautomation.utils.CurrencyRateCalculator.calculateSellRatePerGel;
import static ge.tbc.testautomation.utils.CurrencyRateCalculator.parseCalculatorRate;

public class CurrencySteps extends BaseSteps {
    CurrencyPage currencyPage;
    List<String> currencies;
    String rate;

    public CurrencySteps(Page page) {
        super(page);
        this.currencyPage = new CurrencyPage(page);
    }

    public CurrencySteps ensurePageNavigatedToCurrencies(String title) {
        PlaywrightAssertions.assertThat(currencyPage.currencyPageTitle).hasText(title);
        return this;
    }

    public CurrencySteps verifyPopularCurrenciesAppear() {
        PlaywrightAssertions.assertThat(currencyPage.popularCurrenciesWrapper).isVisible();
        return this;
    }

    public CurrencySteps verifyCalculatorIsVisible() {
        PlaywrightAssertions.assertThat(currencyPage.calculator).isVisible();
        return this;
    }

    public List<String> getPopularCurrencies() {
        this.currencies = new ArrayList<>();
        for (int i = 0; i < currencyPage.popularCurrencies.count(); i++) {
            currencies.add(currencyPage.currencyName.nth(i).innerText());
        }
        return currencies;
    }

    public CurrencySteps getRate(String currency, String sellOrBuy) {
        int currencyIndex = currencies.indexOf(currency);
        currencyPage.getCurrencyDetails(currencyIndex);
        currencyPage.getSellOrBuyRate(sellOrBuy);
        this.rate = currencyPage.sellBuyRate.innerText();
        return this;
    }

    public CurrencySteps enterAmount(int amount) {
        currencyPage.selectAmountInput();
        currencyPage.amountInput.click();
        for (int i = 0; i < 4; i++) {
            page.keyboard().press("Backspace");
        }
        page.keyboard().type(String.valueOf(amount));
        return this;
    }

    public CurrencySteps openDropdownFrom() {
        currencyPage.dropdownFrom.click();
        return this;
    }

    public CurrencySteps openDropdownTo() {
        currencyPage.dropdownTo.click();
        return this;
    }

    public CurrencySteps selectCurrency(String currency) {
        currencyPage.currencyList.getByText(currency).click();
        return this;
    }

    public CurrencySteps reverse() {
        currencyPage.reverseButton.click();
        return this;
    }

    public CurrencySteps assertBuyingCurrency(String currency) {
        PlaywrightAssertions.assertThat(currencyPage.dropdownTo).hasText(currency);
        return this;
    }

    public CurrencySteps assertSellingCurrency(String currency) {
        PlaywrightAssertions.assertThat(currencyPage.dropdownFrom).hasText(currency);
        return this;
    }

    public CurrencySteps verifyDisplayedSellRate() {
        String expectedCalculationRate = calculateSellRatePerGel(rate);
        String rateDisplayedOnCalculator = parseCalculatorRate(currencyPage.rateOnCalculator.innerText());
        Assert.assertEquals(expectedCalculationRate, rateDisplayedOnCalculator);
        return this;
    }

    public CurrencySteps verifyDisplayedBuyRate() {
        String rateDisplayedOnCalculator = parseCalculatorRate(currencyPage.rateOnCalculator.innerText());
        Assert.assertEquals(rate, rateDisplayedOnCalculator);
        return this;
    }


}


