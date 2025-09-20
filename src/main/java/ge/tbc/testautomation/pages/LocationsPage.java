package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LocationsPage {
    public Locator pageTitle;
    public Locator mapWrapper;
    public Locator cityDropdown;
    public Locator dropdownOption;
    public Locator selectedCity;
    public Locator branchesListWrapper;
    public Locator branchesListItems;
    public Locator listItemAddress;
    public Locator relatedPin;
    public Locator selectedPin;
    public Locator visiblePins;
    public Locator searchInput;
    public Locator tabMenu;
    public Locator tabButtons;
    public Locator tabButton;
    public Locator itemLabel;
    public Locator workingHours;
    public Locator currencyInfo;
    public Locator checkBoxFilters;
    public Locator subTab;

    public LocationsPage(Page page) {
        this.pageTitle = page.locator("h2.tbcx-pw-atm-branches-section__title");
        this.mapWrapper = page.locator("app-atm-branches-section-map .map-container");
        this.cityDropdown = page.locator("div.tbcx-dropdown-selector");
        this.dropdownOption = page.locator(".tbcx-dropdown-popover-item__title");
        this.selectedCity = page.locator(".tbcx-selected-container .tbcx-dropdown-selector__selection-text__slot__container");
        this.branchesListWrapper = page.locator(".tbcx-pw-atm-branches-section__map-wrapper .tbcx-pw-atm-branches-section__list-wrapper");
        this.branchesListItems = page.locator(".tbcx-pw-atm-branches-section__list-item");
        this.relatedPin = page.locator("gmp-advanced-marker .active");
        this.selectedPin = relatedPin.locator("..");
        this.visiblePins = page.locator("gmp-advanced-marker");
        this.searchInput = page.locator("#tbcx-text-input-1");
        this.tabMenu = page.locator("tbcx-pw-tab-menu .tbcx-pw-tab-menu");
        this.tabButtons = tabMenu.locator(".tbcx-pw-tab-menu__item");
        this.itemLabel = page.locator(".tbcx-pw-atm-branches-section__list-item .tbcx-pw-atm-branches-section__list-item-label");
        this.checkBoxFilters = page.locator("app-atm-branches-checkbox-filters");
        this.subTab = page.locator(".tbcx-pw-chip .tbcx-pw-chip__checkmark");
        this.workingHours = page.locator(".tbcx-pw-atm-branches-section__list-item .tbcx-pw-atm-branches-section__list-item-description");
        this.currencyInfo = page.locator("tbcx-pw-atm-branches-section__list-item .tbcx-pw-atm-branches-section__list-item-currencies");

    }

    public void getDescription(int i) {
        this.listItemAddress = branchesListItems.nth(i).locator(".tbcx-pw-atm-branches-section__list-item-title");
    }

    public void getButtonByName(String name) {
        this.tabButton = tabButtons.getByText(name).locator("..");
    }
}
