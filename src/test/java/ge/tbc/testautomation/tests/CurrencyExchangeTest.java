package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.runners.BaseTest;
import ge.tbc.testautomation.runners.MobileEmulationBaseTest;
import ge.tbc.testautomation.steps.CurrencySteps;
import ge.tbc.testautomation.steps.HomeSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class CurrencyExchangeTest extends MobileEmulationBaseTest {
    HomeSteps homeSteps;
    CurrencySteps currencySteps;
    List<String> popularCurrencies;

    @BeforeClass
    public void initSteps() {
        this.homeSteps= new HomeSteps(page);
        this.currencySteps = new CurrencySteps(page);

    }

    @Test(priority = 1)
    public void navigateToCurrenciesPage() {
        homeSteps
                .goToCurrencyExchange();
        currencySteps
                .ensurePageNavigatedToCurrencies(Constants.CURRENCY_PAGE_TITLE)
                .verifyPopularCurrenciesAppear();
        this.popularCurrencies = currencySteps.getPopularCurrencies();
    }

    @Test(priority = 2)
    public void popCurrencyToGelCalculator() {
        currencySteps
                .verifyCalculatorIsVisible()
                .enterAmount(Constants.AMOUNT_TO_EXCHANGE);
        for (var currency : popularCurrencies) {
            currencySteps
                    .getRate(currency, Constants.TO_BUY)
                    .openDropdownFrom()
                    .selectCurrency(currency)
                    .assertBuyingCurrency(Constants.DEFAULT_CURRENCY)
                    .verifyDisplayedBuyRate();
        }
    }

    @Test(priority = 3)
    public void reverseExchange() {
        currencySteps
                .reverse()
                .assertSellingCurrency(Constants.DEFAULT_CURRENCY);
    }

    @Test(priority = 4)
    public void gelToPopCurrencyCalculator() {
        for (var currency : popularCurrencies) {
            currencySteps
                    .getRate(currency, Constants.TO_SELL)
                    .verifyCalculatorIsVisible()
                    .openDropdownTo()
                    .selectCurrency(currency)
                    .verifyDisplayedSellRate();
        }
    }

}
