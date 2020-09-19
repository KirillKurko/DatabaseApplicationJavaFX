package application.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtility {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    private static Connection connection = null;

    private static final String connectionString =  "jdbc:mysql://localhost/Countries";

    public static void connectDatabase() throws SQLException, ClassNotFoundException {
        registerDriver();

        try {
            connection = DriverManager.getConnection(connectionString, "root", "12qazwsxEDC");
        }
        catch (SQLException exception) {
            System.out.println("Connection failed" + exception);
            throw exception;
        }
    }

    public static void registerDriver() throws ClassNotFoundException {
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
}
