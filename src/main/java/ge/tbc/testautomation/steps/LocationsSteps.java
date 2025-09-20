package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.WaitForSelectorState;
import ge.tbc.testautomation.pages.LocationsPage;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static ge.tbc.testautomation.utils.CustomCss.assertIsSelected;
import static ge.tbc.testautomation.utils.MapUtil.*;

public class LocationsSteps extends BaseSteps {
    String resultStreet;
    LocationsPage locationsPage;
    String selectedPinCoordinates;
    List<String> coordinates;
    int totalCount;
    int atmCount;
    int branchesCount;
    int cdmCount;

    public LocationsSteps(Page page) {
        super(page);
        this.locationsPage = new LocationsPage(page);
    }

    public LocationsSteps ensurePageNavigatedToLocations(String title) {
        PlaywrightAssertions.assertThat(locationsPage.pageTitle).hasText(title);
        return this;
    }

    public LocationsSteps waitForMap() {
        locationsPage.mapWrapper.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(5000));
        locationsPage.visiblePins.first().waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.ATTACHED).setTimeout(5000));
        return this;
    }

    public LocationsSteps openDropdownList() {
        locationsPage.cityDropdown.click();
        return this;
    }

    public LocationsSteps assertListNotEmpty() {
        PlaywrightAssertions.assertThat(locationsPage.dropdownOption).not().hasCount(0);
        return this;
    }

    public LocationsSteps selectCity(String city) {
        locationsPage.dropdownOption.getByText(city).click();
        return this;
    }

    public LocationsSteps verifyBranchesAtmWrapperIsVisible() {
        PlaywrightAssertions.assertThat(locationsPage.branchesListWrapper).isVisible();
        return this;
    }

    public LocationsSteps verifySubTabsVisible() {
        PlaywrightAssertions.assertThat(locationsPage.checkBoxFilters).isVisible();
        return this;
    }

    public LocationsSteps verifyResultsAppeared() {
        PlaywrightAssertions.assertThat(locationsPage.branchesListItems).not().hasCount(0);
        return this;
    }

    public LocationsSteps getCoordinates() {
        this.coordinates = new ArrayList<>();
        for (int i = 0; i < locationsPage.visiblePins.count(); i++) {
            String position = locationsPage.visiblePins.nth(i).getAttribute("position");
            coordinates.add(position);
        }
        return this;
    }

    public LocationsSteps verifyMapIsCentered(String city) {
        // default to null region
        return verifyMapIsCentered(city, null);
    }

    public LocationsSteps verifyMapIsCentered(String city, String region) {
        String center = calculateCenter(coordinates);
        if (getCity(center).isEmpty()) {
            Assert.assertEquals(getRegion(center), region);
        } else {
            Assert.assertEquals(getCity(center), city);
        }
        return this;
    }

    public LocationsSteps assertCityFilterIsApplied(String city) {
        PlaywrightAssertions.assertThat(locationsPage.selectedCity).hasText(city);
        return this;
    }

    public LocationsSteps selectResult(int i) {
        locationsPage.branchesListItems.nth(i).click();
        locationsPage.selectedBranch.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.ATTACHED));
        return this;
    }

    public LocationsSteps assertBranchIsSelected(int i) {
        locationsPage.branchesListItems.nth(i).click(); //performin' action to receive updated class
        Locator resultsItem = locationsPage.branchesListItems.nth(i);
        assertIsSelected(resultsItem);
        return this;
    }

    public LocationsSteps assertWorkingHoursVisible(int i) {
        PlaywrightAssertions.assertThat(locationsPage.workingHours.nth(i)).isVisible();
        return this;
    }

    public LocationsSteps assertDescriptionVisible(int i) {
        PlaywrightAssertions.assertThat(locationsPage.itemLabel.nth(i)).isVisible();
        return this;
    }

    public LocationsSteps checkForRelatedPin() {
        locationsPage.relatedPin.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.ATTACHED));
        return this;
    }

    public LocationsSteps getSelectedPinCoordinates() {
        this.selectedPinCoordinates = locationsPage.selectedPin.getAttribute("position");
        return this;
    }

    public LocationsSteps verifyPinIsFromFilteredCity(String city) {
        boolean isInCity = isCoordinateInExpectedCity(selectedPinCoordinates, city);
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

    public LocationsSteps getResultsAddress(int index) {
        locationsPage.getDescription(index);
        this.resultStreet = locationsPage.listItemAddress.innerText();
        return this;
    }

    public LocationsSteps verifyResultHasCorrectStreetAddress(String street) {
        Assert.assertTrue(resultStreet.contains(street));
        return this;
    }

    //tabs and state
    public LocationsSteps verifyTabMenuIsVisible() {
        PlaywrightAssertions.assertThat(locationsPage.tabMenu).isVisible();
        return this;
    }

    public LocationsSteps verifyTabButtonsAreInteractive() {
        for (int i = 0; i <locationsPage.tabButtons.count() ; i++) {
            Assert.assertTrue(locationsPage.tabButtons.nth(i).isEnabled());
        }
        return this;
    }

    public LocationsSteps verifyTabIsActive(String tabName) {
        locationsPage.getButtonByName(tabName);
        assertIsSelected(locationsPage.tabButton);
        return this;
    }

    public LocationsSteps getCountOfAllAtmBranches() {
        this.totalCount = locationsPage.branchesListItems.count();
        return this;
    }

    public LocationsSteps switchToTab(String tabName) {
        locationsPage.getButtonByName(tabName);
        locationsPage.tabButton.click();
        return this;
    }

    public LocationsSteps getATMsCount() {
        this.atmCount = locationsPage.branchesListItems.count();
        return this;
    }

    public LocationsSteps verifyAllResultsAreAtm(String text) {
        for (int i = 0; i < atmCount; i++) {
            PlaywrightAssertions.assertThat(locationsPage.itemLabel.nth(i)).containsText(text);
        }
        return this;
    }

    public LocationsSteps getBranchesCount() {
        this.branchesCount = locationsPage.branchesListItems.count();
        return this;
    }

    public LocationsSteps verifyAllResultsAreBranch(String text) {
        for (int i = 0; i < branchesCount; i++) {
            PlaywrightAssertions.assertThat(locationsPage.itemLabel.nth(i)).containsText(text);
        }
        return this;
    }

    public LocationsSteps getCDMsCount() {
        this.cdmCount = locationsPage.branchesListItems.count();
        return this;
    }

    public LocationsSteps verifyAllResultsAreCdm(String text) {
        for (int i = 0; i < cdmCount; i++) {
            PlaywrightAssertions.assertThat(locationsPage.itemLabel.nth(i)).containsText(text);
        }
        return this;
    }

    public LocationsSteps verifyTotalCount() {
        Assert.assertEquals(totalCount, cdmCount + atmCount + branchesCount);
        return this;
    }

    public LocationsSteps selectSubTab(String name) {
        locationsPage.subTab.getByText(name).click();
        return this;
    }

    public LocationsSteps verifyResultsFilteredCorrectly(String workingHours) {
        for (int i = 0; i < locationsPage.workingHours.count(); i++) {
            PlaywrightAssertions.assertThat(locationsPage.workingHours.nth(i)).containsText(workingHours);
        }
        return this;
    }

     public LocationsSteps unSelect(String name) {
         locationsPage.subTab.getByText(name).click();
         return this;
     }

     public LocationsSteps verifyResultsAreResetBack() {
         Assert.assertEquals(locationsPage.branchesListItems.count(), totalCount);
        return this;
     }
}
