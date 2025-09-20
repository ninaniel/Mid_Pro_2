package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.ConcreteOfferPage;
import org.testng.Assert;

public class ConcreteOfferSteps extends OffersSteps {
    ConcreteOfferPage offerPage;

    public ConcreteOfferSteps(Page page) {
        super(page);
        this.offerPage = new ConcreteOfferPage(page);
    }

    public ConcreteOfferSteps ensurePageOpenedCorrectOffer() {
        Assert.assertEquals(offerPage.offerPageTitle.innerText(), selectedOfferTitle);
        return this;
    }

    public ConcreteOfferSteps goBackToOffers() {
        page.goBack();
        return this;
    }

}
