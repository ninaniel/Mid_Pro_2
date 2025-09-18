package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.utils.SQLConnection;

import java.sql.*;

public class DatabaseSteps {

    public ResultSet getAllStreets() {
        try {
            Connection connection = SQLConnection.connect();

            String SQL = "SELECT * FROM StreetCases";
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            return statement.executeQuery(SQL);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
