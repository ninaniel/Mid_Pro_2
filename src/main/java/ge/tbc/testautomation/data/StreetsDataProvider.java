package ge.tbc.testautomation.data;
import ge.tbc.testautomation.steps.DatabaseSteps;
import org.testng.annotations.DataProvider;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StreetsDataProvider {

    @DataProvider(name = "streetsData")
    public static Object[][] getStreetsData() {

        try {
            DatabaseSteps dbSteps = new DatabaseSteps();
            ResultSet resultSet = dbSteps.getAllStreets();

            resultSet.last();
            int rowCount = resultSet.getRow(); // getting row count
            resultSet.beforeFirst();
            Object[][] dataList = new Object[rowCount][resultSet.getMetaData().getColumnCount()];

            int iter = 0;
            while (resultSet.next()) {
                dataList[iter] = new Object[]{
                        resultSet.getString("street"),
                        resultSet.getInt("expected_result_count")
                };
                iter ++;
            }
            return dataList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
