package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;
import ge.tbc.testautomation.pages.OffersPage;
import org.testng.Assert;

import java.util.Random;

public class OffersSteps extends BaseSteps {
    OffersPage offersPage;
    String beforeHtml;
    String firstOfferBefore;
    int selectedOfferIndex;
    String selectedOfferTitle;

    public OffersSteps(Page page) {
        super(page);
        this.offersPage = new OffersPage(page);
    }

    public OffersSteps observeOffersList() {
        this.beforeHtml = offersPage.offersListWrapper.innerHTML();
//        this.firstOfferBefore = offersPage.offers.first().innerText();
        return this;
    }

    public OffersSteps applyFilter(String[] filterOptions) {
        for (var option : filterOptions) {
//            offersPage.filterOptions.getByText(option).click();
            offersPage.getFilter(option);
            offersPage.filter.check();
        }
        return this;
    }

    public OffersSteps verifyResultsAreVisible() {
        offersPage.offersListWrapper.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(5000));
        return this;
    }

    public OffersSteps verifyListIsUpdated() {
        Assert.assertNotEquals(beforeHtml, offersPage.offersListWrapper.innerHTML());
//        Assert.assertNotEquals(firstOfferBefore, offersPage.offers.first().innerText());
        return this;
    }

    public OffersSteps selectRandomOffer() {
        int offersCount = offersPage.offers.count();
        Random random = new Random();
        this.selectedOfferIndex = random.nextInt(offersCount);
        return this;
    }

    public OffersSteps getOfferTitle() {
        offersPage.getOfferTitle(selectedOfferIndex);
        selectedOfferTitle = offersPage.offersTitle.innerText();
        return this;
    }

    public OffersSteps openOfferDetails() {
        offersPage.offers.nth(selectedOfferIndex).click();
        return this;
    }

    public OffersSteps verifyOffersPageLoaded(String title) {
        page.waitForLoadState(LoadState.NETWORKIDLE);
        PlaywrightAssertions.assertThat(offersPage.pageTitle).hasText(title);
        return this;
    }

    public OffersSteps verifyFiltersRemainedChecked(String[] filterOptions) {
        page.waitForLoadState(LoadState.NETWORKIDLE);
        for (var option:filterOptions) {
            offersPage.getFilter(option);
            Assert.assertTrue(offersPage.filter.isChecked());
        }
        return this;
    }

    public OffersSteps clearFilters() {
        while (offersPage.clearButton.count()>0) {
            offersPage.clearButton.first().click();
        }
        return this;
    }

    public OffersSteps verifyNoFiltersAreApplied(){
        PlaywrightAssertions.assertThat(offersPage.clearButton).not().isVisible();
        return this;
    }

    public OffersSteps verifyListIsEmpty() {
        PlaywrightAssertions.assertThat(offersPage.offersListWrapper).not().isAttached();
        return this;
    }

    public OffersSteps verifyMessageAppeared(String text) {
        PlaywrightAssertions.assertThat(offersPage.noResultsMsg).hasText(text);
        return this;
    }



}
