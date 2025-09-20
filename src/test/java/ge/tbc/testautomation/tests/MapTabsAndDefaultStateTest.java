package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.runners.LocationBaseTest;
import ge.tbc.testautomation.steps.HomeSteps;
import ge.tbc.testautomation.steps.LocationsSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MapTabsAndDefaultStateTest extends LocationBaseTest {
    HomeSteps homeSteps;
    LocationsSteps locationsSteps;

    @BeforeClass
    public void initSteps() {
        this.homeSteps = new HomeSteps(page);
        this.locationsSteps = new LocationsSteps(page);
    }

    @Test(priority = 1)
    public void navigateToLocationsStep() {
        homeSteps
                .goToAtmAndBranches();
        locationsSteps
                .ensurePageNavigatedToLocations(Constants.LOCATIONS_PAGE_TITLE)
                .verifyBranchesAtmWrapperIsVisible()
                .waitForMap()
                .verifyMapIsCentered(Constants.USER_LOCATION_CITY)
                .verifyTabMenuIsVisible()
                .verifyTabIsActive(Constants.TAB_BUTTON_ALL)
                .verifySubTabsVisible();
    }

    @Test(priority = 2)
    public void viewAtmsStep() {
        locationsSteps
                .verifyTabButtonsAreInteractive()
                .getCountOfAllAtmBranches()
                .switchToTab(Constants.TAB_BUTTON_ATM)
                .verifyTabIsActive(Constants.TAB_BUTTON_ATM)
                .getATMsCount()
                .verifyAllResultsAreAtm(Constants.DESCRIPTION_ATM);
    }

    @Test(priority = 3)
    public void viewBranchesStep() {
        locationsSteps
                .switchToTab(Constants.TAB_BUTTON_BRANCHES)
                .verifyTabIsActive(Constants.TAB_BUTTON_BRANCHES)
                .getBranchesCount()
                .verifyAllResultsAreBranch(Constants.DESCRIPTION_BRANCH);
    }

    @Test(priority = 4)
    public void viewCdmsStep() {
        locationsSteps
                .switchToTab(Constants.TAB_BUTTON_CDM)
                .verifyTabIsActive(Constants.TAB_BUTTON_CDM)
                .getCDMsCount()
                .verifyAllResultsAreCdm(Constants.DESCRIPTION_CDM);
    }

    @Test(priority = 5)
    public void backToAllStep() {
        locationsSteps
                .switchToTab(Constants.TAB_BUTTON_ALL)
                .verifyTotalCount();
    }

    @Test(priority = 6)
    public void filterBySubtabStep() {
        locationsSteps
                .selectSubTab(Constants.SUB_TAB)
                .verifyResultsFilteredCorrectly(Constants.SUB_TAB);
    }

    @Test(priority = 7)
    public void removeFilterStep() {
        locationsSteps
                .unSelect(Constants.SUB_TAB)
                .verifyResultsAreResetBack();
    }
}
