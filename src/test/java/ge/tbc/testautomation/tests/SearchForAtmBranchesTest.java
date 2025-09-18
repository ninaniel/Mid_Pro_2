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
    public void locationTest() {
        homeSteps.goToAtmAndBranches();
        locationsSteps
                .ensurePageNavigatedToLocations(Constants.LOCATIONS_PAGE_TITLE)
                .verifyMapIsVisible()
                .openDropdownList();
        if (locationsSteps.listNotEmpty()) {locationsSteps.selectCity(Constants.CITY_TO_FILTER_LOCATION);}
        locationsSteps
                .verifyBranchesAtmWrapperIsVisible()
                .verifyResultsAppeared();
        for (int i=0; i<5; i++) {
            locationsSteps
                    .selectResult(i)
                    .checkForRelatedPin()
                    .getCoordinates()
                    .verifyPinIsFromFilteredCity(Constants.CITY_EN);
        }
    }

    @Test(priority = 2, dataProvider = "streetsData", dataProviderClass = StreetsDataProvider.class)
    public void dataTest(String street, int expectedCount){
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
