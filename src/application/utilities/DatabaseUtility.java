package application.utilities;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.*;

public class DatabaseUtility {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    private static Connection connection = null;

    private static final String connectionString =  "jdbc:mysql://localhost/Countries";

    private static final String user = "root";

    private static final String password = "12qazwsxEDC";

    public static void connectDatabase() throws SQLException, ClassNotFoundException {
        registerDriver();
        createConnection();
    }

    private static void registerDriver() throws ClassNotFoundException {
        try {
            Class.forName(JDBC_DRIVER);
        }
        catch (ClassNotFoundException exception) {
            System.out.println("MySQL JDBC Driver not found");
            exception.printStackTrace();
            throw exception;
        }
        System.out.println("MySQL JDBC Driver has been registered");
    }

    private static void createConnection() throws SQLException {
        try {
            connection = DriverManager.getConnection(connectionString, user, password);
        }
        catch (SQLException exception) {
            System.out.println("Connection failed" + exception);
            throw exception;
        }
    }

    public static void disconnectDatabase() throws SQLException {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        catch (Exception exception) {
            throw exception;
        }
    }

    public static void executeQuery(String SQLStatement) throws SQLException, ClassNotFoundException {
        Statement statement = null;
        try {
            connectDatabase();
            connection.createStatement();
            statement.executeUpdate(SQLStatement);
        }
        catch (SQLException exception) {
            System.out.println("Executing query error " + exception);
            throw exception;
        }
        finally {
            if (statement != null) {
                statement.close();
            }
            disconnectDatabase();
        }
    }

    public static ResultSet execute(String SQLQuery) throws SQLException, ClassNotFoundException {
        Statement statement = null;
        ResultSet resultSet = null;
        CachedRowSetImpl cachedRowSet;
        try {
            connectDatabase();
            connection.createStatement();
            resultSet = statement.executeQuery(SQLQuery);
            cachedRowSet = new CachedRowSetImpl();
            cachedRowSet.populate(resultSet);
        }
        catch (SQLException exception) {
            System.out.println("Execute error " + exception);
            throw exception;
        }
        finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            disconnectDatabase();
        }
        return cachedRowSet;
    }
}
