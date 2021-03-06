package application.model;

import application.utilities.DatabaseUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO {

    private static final String INSERT_COUNTRY = "INSERT INTO Countries(name, capital, language) VALUES (?, ?, ?);";
    private static final String UPDATE_ID = "UPDATE Countries SET name = ?, capital = ?, language = ? WHERE id = ?;";
    private static final String SELECT_ID = "SELECT * FROM Countries WHERE id = ?;";
    private static final String SELECT_NAME = "SELECT * FROM Countries WHERE name = ?;";
    private static final String SELECT_CAPITAL = "SELECT * FROM Countries WHERE capital = ?;";
    private static final String SELECT_LANGUAGE = "SELECT * FROM Countries WHERE language = ?;";
    private static final String SELECT_ALL_COUNTRIES = "SELECT * FROM Countries;";
    private static final String DELETE_ID = "DELETE FROM Countries WHERE id = ?;";

    public void insertCountry(Country country) {
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COUNTRY)) {
            preparedStatement.setString(1, country.getName());
            preparedStatement.setString(2, country.getCapital());
            preparedStatement.setString(3, country.getLanguage());
            preparedStatement.executeUpdate();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public boolean updateCountry(Country country) {
        boolean rowUpdated = false;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ID)) {
            preparedStatement.setString(1, country.getName());
            preparedStatement.setString(2, country.getCapital());
            preparedStatement.setString(3, country.getLanguage());
            preparedStatement.setInt(4, country.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowUpdated;
    }

    public List<Country> selectCountryByID(int id) {
        List<Country> countries = new ArrayList<>();
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String capital = resultSet.getString("capital");
                String language = resultSet.getString("language");
                countries.add(new Country(id, name, capital, language));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return countries;
    }

    public List<Country> selectCountryByName(String name) {
        List<Country> countries = new ArrayList<>();
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NAME)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String capital = resultSet.getString("capital");
                String language = resultSet.getString("language");
                countries.add(new Country(id, name, capital, language));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return countries;
    }

    public List<Country> selectCountryByCapital(String capital) {
        List<Country> countries = new ArrayList<>();
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CAPITAL)) {
            preparedStatement.setString(1, capital);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String language = resultSet.getString("language");
                countries.add(new Country(id, name, capital, language));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return countries;
    }

    public List<Country> selectCountryByLanguage(String language) {
        List<Country> countries = new ArrayList<>();
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LANGUAGE)) {
            preparedStatement.setString(1, language);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String capital = resultSet.getString("capital");
                countries.add(new Country(id, name, capital, language));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return countries;
    }

    public List<Country> selectAllCountries() {
        List<Country> countries = new ArrayList<>();
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COUNTRIES)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("name");
                String capital = resultSet.getString("capital");
                String language = resultSet.getString("language");
                countries.add(new Country(id, name, capital, language));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return countries;
    }

    public boolean deleteCountry(int id) {
        boolean rowDeleted = false;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ID)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowDeleted;
    }
}
