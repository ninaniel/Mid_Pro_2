package ge.tbc.testautomation.utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.json.JSONObject;

public class MapUtil {
    private static String lat;
    private static String lon;

    private static JSONObject getAddressFromCoordinates(String lat, String lon) {
        try {
            String urlStr = String.format(
                    "https://nominatim.openstreetmap.org/reverse?lat=%s&lon=%s&format=json&accept-language=en",
                    lat, lon);
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "TestAutomationBot"); // required by nominatim

            String response = new Scanner(con.getInputStream())
                    .useDelimiter("\\A")
                    .next();

            JSONObject obj = new JSONObject(response);
            return obj.getJSONObject("address");

        } catch (Exception e) {
            e.printStackTrace();
            return new JSONObject(); // return empty object if error
        }
    }

    private static void parseCoordinates(String coordinates) {
        String[] parts = coordinates.split(",");
        lat = parts[0];
        lon = parts[1];
    }

    public static String getRoad(String coordinates) {
        parseCoordinates(coordinates);
        JSONObject address = getAddressFromCoordinates(lat, lon);
        return address.optString("road", "");
    }

    public static String getCity(String coordinates) {
        parseCoordinates(coordinates);
        JSONObject address = getAddressFromCoordinates(lat, lon);
        return address.optString("city", "");
    }

    public static boolean isCoordinateInExpectedCity(String coordinates, String expectedCity) {
        parseCoordinates(coordinates);
        JSONObject address = getAddressFromCoordinates(lat, lon);
        String actualCity = address.optString("city", "");
        return actualCity.equalsIgnoreCase(expectedCity);
    }

    public static String calculateCenter(List<String> coordinates) {
        double sumLat = 0;
        double sumLng = 0;
        int count = coordinates.size();

        for (String coord : coordinates) {
            parseCoordinates(coord);
            double latDouble = Double.parseDouble(lat.trim());
            double lonDouble = Double.parseDouble(lon.trim());
            sumLat += latDouble;
            sumLng += lonDouble;
        }

        double centerLat = sumLat / count;
        double centerLng = sumLng / count;

        return centerLat + "," + centerLng;
    }
}