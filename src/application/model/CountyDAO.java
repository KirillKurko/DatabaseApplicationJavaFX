package application.model;

import application.utilities.DatabaseUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CountyDAO {

    private static final String INSERT_COUNTRY = "INSERT INTO Countries(name, capital, language) VALUES (?, ?, ?);";
    private static final String SELECT_ID = "SELECT * Countries WHERE id = ?;";
    private static final String SELECT_ALL_COUNTRIES = "SELECT * FROM Countries;";
    private static final String DELETE_ID = "DELETE FROM Countries WHERE id = ?;";
    private static final String UPDATE_ID = "UPDATE Countries SET name = ?, capital = ?, language = ? WHERE id = ?;";

    public void insertCountry(Country country) throws SQLException {
        try (Connection connection = DatabaseUtility.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COUNTRY);
            preparedStatement.setString(1, country.getName());
            preparedStatement.setString(2, country.getCapital());
            preparedStatement.setString(3, country.getLanguage());
            preparedStatement.executeUpdate();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
