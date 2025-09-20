package ge.tbc.testautomation.utils;

import ge.tbc.testautomation.data.Constants;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyRateCalculator {

    public static String calculateSellRatePerGel(String rateText) {
        double rateDouble = Double.parseDouble(rateText);
        double sellRate = Constants.AMOUNT_TO_EXCHANGE / rateDouble /Constants.AMOUNT_TO_EXCHANGE; //rate displayed is 1gel to..
        BigDecimal rateBD = BigDecimal.valueOf(sellRate).setScale(4, RoundingMode.HALF_UP).stripTrailingZeros();

        return rateBD.toPlainString();
//        return String.format("%.4f", sellRate);
    }

    public static String parseCalculatorRate(String rateText) {
        String[] parts = rateText.split("=");
        // remove all except dot &numbers
        String numberPart = parts[1].replaceAll("[^0-9.]", "").trim();

        return numberPart;
    }
}
