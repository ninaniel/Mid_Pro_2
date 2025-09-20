package ge.tbc.testautomation.data;

import org.testng.annotations.DataProvider;

public class OffersDataProvider {

    @DataProvider(name = "offersFilters")
    public static Object[][] provideFilters() {
        return new Object[][]{
                { new String[]{"ავტო", "ფასდაკლება"} },
//                { new String[]{"დასვენება", "კაფე და რესტორანი", "ჯანმრთელობა და სილამაზე"} },
//                { new String[]{"შოპინგი", "განაწილება"} },
                { new String[]{"ტანსაცმელი", "მოსწავლის ბარათი"} },
                { new String[]{"სახლი", "დეველოპერები", "თიბისი ბარათი კონცეპტი", "პარტნიორების შეთავაზება"} },
                { new String[]{"მოგზაურობა", "ონლაინ პარტნიორები","სამოგზაურო ბარათი", "ფასდაკლება", "ვიზა"} },
//                { new String[]{"ტექნიკა", "საკრედიტო ბარათი", "ქეშბექი"} },
                { new String[]{"განათლება", "თიბისი ბარათი კონცეპტი"} },
//                { new String[]{"ქეშბექი", "ფასდაკლება"} },
        };
    }
}
