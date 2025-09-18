package ge.tbc.testautomation.utils;

public class TextParser {

    public static String getNumber(String rawText) {
        return rawText.replaceAll("[^0-9]", "");
    }

    public static String getCurrency(String rawText) {
        return rawText.replaceAll("[0-9,]", "").trim();
    }

    public static String parseStreet(String street) {
        if (street.endsWith("ძე")) {
            street = street.substring(0, street.length() - 1);
        }
        return street;
    }


}