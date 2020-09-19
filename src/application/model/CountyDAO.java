package application.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CountyDAO {

    private String jdbcDriver  = "com.mysql.jdbc.Driver";
    private String jdbcURL =  "jdbc:mysql://localhost/Countries";
    private String jdbcUserame = "root";
    private String jdbcPassword = "12qazwsxEDC";

    private static final String INSERT_COUNTRY = "INSERT INTO Countries(name, capital, language) VALUES (?, ?, ?);";
    private static final String SELECT_ID = "SELECT * Countries WHERE id = ?;";
    private static final String SELECT_ALL_COUNTRIES = "SELECT * FROM Countries;";
    private static final String DELETE_ID = "DELETE FROM Countries WHERE id = ?;";
    private static final String UPDATE_ID = "UPDATE Countries SET name = ?, capital = ?, language = ? WHERE id = ?;";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(jdbcURL, jdbcUserame, jdbcPassword);
        }
        catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return connection;
    }
    
    public void insertCountry(Country country) throws SQLException {
        try (Connection connection = getConnection()) {
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
