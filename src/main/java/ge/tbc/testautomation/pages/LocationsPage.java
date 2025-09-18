package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LocationsPage {
    public Locator pageTitle;
    public Locator mapWrapper;
    public Locator cityDropdown;
    public Locator dropdownOption;
    public Locator branchesListWrapper;
    public Locator branchesListItems;
    public Locator listItemAddress;
    public Locator relatedPin;
    public Locator selectedPin;
    public Locator visiblePins;
    public Locator searchInput;

    public LocationsPage(Page page) {
        this.pageTitle = page.locator("h2.tbcx-pw-atm-branches-section__title");
        this.mapWrapper = page.locator("app-atm-branches-section-map .map-container");
        this.cityDropdown = page.locator("div.tbcx-dropdown-selector");
        this.dropdownOption = page.locator(".tbcx-dropdown-popover-item__title");
        this.branchesListWrapper = page.locator(".tbcx-pw-atm-branches-section__map-wrapper .tbcx-pw-atm-branches-section__list-wrapper");
        this.branchesListItems = page.locator(".tbcx-pw-atm-branches-section__list-item");
        this.relatedPin = page.locator("gmp-advanced-marker .active");
        this.selectedPin = relatedPin.locator("..");
        this.visiblePins = page.locator("gmp-advanced-marker");
        this.searchInput = page.locator("#tbcx-text-input-1");

    }

    public void getDescription(int i) {
        this.listItemAddress = branchesListItems.nth(i).locator(".tbcx-pw-atm-branches-section__list-item-title");
    }
}


//tabButtons() {$("          .tbcx-pw-tab-menu button");
