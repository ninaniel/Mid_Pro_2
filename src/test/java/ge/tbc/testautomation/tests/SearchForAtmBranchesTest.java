package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.data.StreetsDataProvider;
import ge.tbc.testautomation.runners.LocationBaseTest;
import ge.tbc.testautomation.steps.HomeSteps;
import ge.tbc.testautomation.steps.LocationsSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static ge.tbc.testautomation.utils.TextParser.parseStreet;

public class SearchForAtmBranchesTest extends LocationBaseTest {
    HomeSteps homeSteps;
    LocationsSteps locationsSteps;

    @BeforeClass
    public void initSteps() {
        this.homeSteps = new HomeSteps(page);
        this.locationsSteps = new LocationsSteps(page);
    }

    @Test(priority = 1)
    public void navigateToLocationsStep() {
        homeSteps.goToAtmAndBranches();
        locationsSteps
                .ensurePageNavigatedToLocations(Constants.LOCATIONS_PAGE_TITLE)
                .waitForMap();
    }

    @Test(priority = 2)
    public void openDropDownStep() {
        locationsSteps
                .openDropdownList()
                .assertListNotEmpty();
    }

    @Test(priority = 3)
    public void selectCityStep() {
        locationsSteps
                .selectCity(Constants.CITY_TO_FILTER_LOCATION)
                .assertCityFilterIsApplied(Constants.CITY_TO_FILTER_LOCATION)
                .verifyBranchesAtmWrapperIsVisible()
                .verifyResultsAppeared()
                .getCoordinates()
                .verifyMapIsCentered(Constants.CITY_EN, Constants.REGION_EN);
    }

    @Test(priority = 4)
    public void checkForResultsStep() {
        for (int i=0; i<5; i++) {
            locationsSteps
                    .selectResult(i)
                    .assertBranchIsSelected(i)
                    .assertWorkingHoursVisible(i)
                    .assertDescriptionVisible(i)
                    .checkForRelatedPin()
                    .getSelectedPinCoordinates()
                    .verifyPinIsFromFilteredCity(Constants.CITY_EN);
        }
        //return Batumi's default state of the map
        locationsSteps
                .openDropdownList()
                .selectCity(Constants.CITY_TO_FILTER_LOCATION);
    }

    @Test(priority = 5, dataProvider = "streetsData", dataProviderClass = StreetsDataProvider.class)
    public void filterByStreetStep(String street, int expectedCount){
        String streetBase = parseStreet(street);
        locationsSteps
                .searchForStreet(streetBase)
                .verifyResultsAppeared()
                .verifyResultsCount(expectedCount);
        for (int i=0; i<expectedCount; i++) {
            locationsSteps
                    .getResultsAddress(i)
                    .verifyResultHasCorrectStreetAddress(streetBase);
        }
    }
}
