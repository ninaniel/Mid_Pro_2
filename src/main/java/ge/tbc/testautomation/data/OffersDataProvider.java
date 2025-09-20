package ge.tbc.testautomation.data;

import org.testng.annotations.DataProvider;

public class OffersDataProvider {

    @DataProvider(name = "offersFilters")
    public static Object[][] provideFilters() {
        return new Object[][]{
                { new String[]{"სახლი", "დეველოპერები", "თიბისი ბარათი კონცეპტი", "პარტნიორების შეთავაზება"} },
                { new String[]{"ავტო", "ფასდაკლება"} },
                { new String[]{"მოგზაურობა", "ონლაინ პარტნიორები","სამოგზაურო ბარათი", "ფასდაკლება", "ვიზა"} },
                { new String[]{"ტანსაცმელი", "მოსწავლის ბარათი"} },
                { new String[]{"განათლება", "თიბისი ბარათი კონცეპტი"} }
        };
    }
}
