package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.data.OffersDataProvider;
import ge.tbc.testautomation.runners.BaseTest;
import ge.tbc.testautomation.steps.ConcreteOfferSteps;
import ge.tbc.testautomation.steps.OffersSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.util.Arrays;

public class OffersFilterTest extends BaseTest {
    ConcreteOfferSteps offersSteps;
    private final String[] filterOptions;

    // call by Factory
    public OffersFilterTest(String[] filterOptions) {
        this.filterOptions = filterOptions;
    }

    @BeforeClass
    public void initSteps() {
        page.navigate(Constants.OFFERS_URL);
        this.offersSteps = new ConcreteOfferSteps(page);
    }

    @Test
    public void setMultipleFiltersStep() {
        offersSteps
                .observeOffersList()
                .applyFilter(filterOptions);

        boolean isZeroResult = Constants.OFFERS_FILTER_WITH_ZERO_RESULT.stream()
                .anyMatch(filters -> Arrays.equals(filters, filterOptions));

        if (isZeroResult) {
            offersSteps
                    .verifyListIsEmpty()
                    .verifyMessageAppeared(Constants.EMPTY_STATE_MSG)
                    .clearFilters();
        } else {
            offersSteps
                    .verifyResultsAreVisible()
                    .verifyListIsUpdated();
        }
    }

    @Test(dependsOnMethods = "setMultipleFiltersStep")
    public void viewOfferDetailsStep() {
        offersSteps
                .selectRandomOffer()
                .getOfferTitle()
                .openOfferDetails();
        offersSteps
                .ensurePageOpenedCorrectOffer();
    }

    @Test(dependsOnMethods = "viewOfferDetailsStep")
    public void backToOffersStep() {
        offersSteps
                .goBackToOffers()
                .verifyOffersPageLoaded(Constants.OFFERS_PAGE_TITLE)
                .verifyResultsAreVisible()
                .verifyFiltersRemainedChecked(filterOptions);
    }

    @Test(dependsOnMethods = "backToOffersStep")
    public void resetToDefaultStep() {
        offersSteps
                .clearFilters()
                .verifyNoFiltersAreApplied();
    }

    // factory to create one class instance per filter set
    @Factory(dataProvider = "offersFilters", dataProviderClass = OffersDataProvider.class)
    public static Object[] createInstances(String[] filterOptions) {
        return new Object[]{ new OffersFilterTest(filterOptions) };
    }
}
