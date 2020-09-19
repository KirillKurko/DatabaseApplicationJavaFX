package application.model;

import application.utilities.DatabaseUtility;

import java.sql.SQLException;

public class CountyDAO {

    public static void addCountry(String name, String capital, String language) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO COUNTRY(name, capital, language) VALUES ('" + name +  "', '" + capital + "', '" + language + "');";
        try {
            DatabaseUtility.executeQuery(sql);
        }
        catch (SQLException exception) {
            System.out.println("Add country error " + exception);
            throw exception;
        }
    }
}
