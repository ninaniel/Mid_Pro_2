package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;
import ge.tbc.testautomation.pages.LocationsPage;
import org.testng.Assert;

import static ge.tbc.testautomation.utils.MapUtil.isCoordinateInExpectedCity;
import static ge.tbc.testautomation.utils.TextParser.parseStreet;

public class LocationsSteps extends BaseSteps {
    String resultStreet;
    LocationsPage locationsPage;
    String coordinates;

    public LocationsSteps(Page page) {
        super(page);
        this.locationsPage = new LocationsPage(page);
    }

    public LocationsSteps ensurePageNavigatedToLocations(String title) {
        PlaywrightAssertions.assertThat(locationsPage.pageTitle).hasText(title);
        return this;
    }

    public LocationsSteps verifyMapIsVisible() {
        locationsPage.mapWrapper.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        return this;
    }

    public LocationsSteps openDropdownList() {
        locationsPage.cityDropdown.click();
        return this;
    }

    public boolean listNotEmpty() {
        return locationsPage.dropdownOption.count() > 0;
    }

    public LocationsSteps selectCity(String city) {
        locationsPage.dropdownOption.getByText(city).click();
        return this;
    }

    public LocationsSteps verifyBranchesAtmWrapperIsVisible() {
        PlaywrightAssertions.assertThat(locationsPage.branchesListWrapper).isVisible();
        return this;
    }

    public LocationsSteps verifyResultsAppeared() {
        PlaywrightAssertions.assertThat(locationsPage.branchesListItems).not().hasCount(0);
        return this;
    }

    public LocationsSteps selectResult(int i) {
        locationsPage.branchesListItems.nth(i).click();
        return this;
    }

    public LocationsSteps checkForRelatedPin() {
        locationsPage.relatedPin.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.ATTACHED));
        return this;
    }

    public LocationsSteps getCoordinates() {
        this.coordinates = locationsPage.selectedPin.getAttribute("position");
        System.out.println(coordinates);
        return this;
    }

    public LocationsSteps verifyPinIsFromFilteredCity(String city) {
        boolean isInCity = isCoordinateInExpectedCity(coordinates, city);
        Assert.assertTrue(isInCity);
        return this;
    }

    public LocationsSteps searchForStreet(String street) {
        locationsPage.searchInput.fill(street);
        return this;
    } //results appeared

    public LocationsSteps verifyResultsCount(int count) {
        PlaywrightAssertions.assertThat(locationsPage.branchesListItems).hasCount(count);
        return this;
    }

    public LocationsSteps verifyVisiblePinsCount(int count) {
        PlaywrightAssertions.assertThat(locationsPage.visiblePins).hasCount(count);
        return this;
    }

    public LocationsSteps getResultsAddress(int index) {
        locationsPage.getDescription(index);
        this.resultStreet = locationsPage.listItemAddress.innerText();
        return this;
    }

    public LocationsSteps verifyResultHasCorrectStreetAddress(String street) {
        Assert.assertTrue(resultStreet.contains(street));
        return this;
    }

    public LocationsSteps verifyBranchHasRelatedPin(int index){
        locationsPage.branchesListItems.nth(index).click();
        PlaywrightAssertions.assertThat(locationsPage.branchesListItems.nth(index)).hasClass("tbcx-pw-atm-branches-section__list-item active");
        PlaywrightAssertions.assertThat(locationsPage.relatedPin).isVisible();
        return this;
//        result.click();
//        result.$(locationsPage.selectedBranch).shouldHave(cssClass("active"));
//        locationsPage.relatedPin.shouldBe(visible);
    }







}
