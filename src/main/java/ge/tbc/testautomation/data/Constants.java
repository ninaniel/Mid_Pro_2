package ge.tbc.testautomation.data;

import java.util.List;

public class Constants {
    public static final String BASE_URL   = "https://tbcbank.ge/ka";
    public static final String LOANS_PATH = "/loans";
    public static final String AUTO_LOANS_PATH = "/loans/auto-loan";
    public static final String OFFERS_URL = "https://tbcbank.ge/ka/offers/all-offers";

    // auto loan
    public static final String AMOUNT_FOR_AUTO_LOAN = "15000";
    public static final String MONTHS_FOR_AUTO_LOAN = "36";
    public static final String CURRENCY_FOR_AUTO_LOAN = "USD";
    public static final String CURRENCY_SYMBOL_FOR_AUTO_LOAN = "$";
    public static final String SIDEBAR_TITLE = "მოითხოვე ზარი";
    public static final String NAME_FOR_CALL_REQUEST = "user name";
    public static final String ID_FOR_CALL_REQUEST = "12345678901";
    public static final String PHONE_FOR_CALL_REQUEST = "123123123";

    //locations
    public static final double TBILISI_LAT = 41.7151;
    public static final double TBILISI_LON = 44.8271;
    public static final String LOCATIONS_PAGE_TITLE = "ფილიალები და  ბანკომატები";
    public static final String CITY_TO_FILTER_LOCATION = "ბათუმი";
    public static final String CITY_EN = "Batumi";
    public static final String REGION_EN = "Autonomous Republic of Adjara";
    public static final String USER_LOCATION_CITY = "Tbilisi";
    public static final String TAB_BUTTON_ALL = "ყველა";
    public static final String TAB_BUTTON_ATM = "ბანკომატები";
    public static final String TAB_BUTTON_BRANCHES = "ფილიალები";
    public static final String TAB_BUTTON_CDM = "თანხის მიმღები";
    public static final String DESCRIPTION_ATM = "ბანკომატი";
    public static final String DESCRIPTION_BRANCH = "ფილიალი";
    public static final String DESCRIPTION_CDM = "თანხის მიმღები";
    public static final String SUB_TAB = "24/7";

    //offers
    public static final String OFFERS_PAGE_TITLE = "შეთავაზებები";
    public static final List<String[]> OFFERS_FILTER_WITH_ZERO_RESULT = List.of(
            new String[]{"ტანსაცმელი", "მოსწავლის ბარათი"},
            new String[]{"ყვავილები", "სამოგზაურო ბარათი"}
    );
    public static final String EMPTY_STATE_MSG = "შეთავაზებები არ მოიძებნა";

    //currencies
    public static final String CURRENCY_PAGE_TITLE = "კომერციული ვალუტის კურსები";
    public static final String DEFAULT_CURRENCY = "GEL";
    public static final int AMOUNT_TO_EXCHANGE = 2800;
    public static final String TO_BUY = "ყიდვა";
    public static final String TO_SELL = "გაყიდვა";



}
