package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class OffersPage {
    public Locator pageTitle;
    public Locator offersListWrapper;
    public Locator offers;
    public Locator offersTitle;
    public Locator filterBoxTitle;
    public Locator filterBox;
    public Locator filterOptions;
    public Locator clearButton;
    public Locator filter;
    public Locator noResultsMsg;

    public OffersPage(Page page) {
        this.pageTitle = page.locator("h2.marketing__header__title");
        this.offersListWrapper = page.locator("app-marketing-list .marketing__cards-list");
        this.offers = offersListWrapper.locator("a");
//        this.filterBoxTitle = page.locator(".filter .filter__top");
//        this.filterBox = filterBoxTitle.locator("..");
        this.filterOptions = page.locator(".filter-item .filter-item__label");
        this.clearButton = page.locator(".filter__top .filter__button");
        this.noResultsMsg = page.locator(".offers__empty-state h3");

    }

    public void getFilter(String filterName) {
        this.filter = filterOptions.filter().getByText(filterName).locator("input[type='checkbox']");
    }

    public void getOfferTitle(int i) {
        this.offersTitle = offers.nth(i).locator("h3");
    }
}
