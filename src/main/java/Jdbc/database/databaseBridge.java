package Jdbc.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface databaseBridge {
    static String url = "jdbc:postgresql://localhost:5432/jdbc";
    static String user = "postgres";
    static String password = "204060";
    // previnir concorrencia
    static final Object lock = new Object();
    static Connection testConnection = null;

    public static Connection establishConnection() {
        synchronized (lock) {
            try {
                if (testConnection == null || testConnection.isClosed()) {
                    return DriverManager.getConnection(url, user, password);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                return null;
            }
        } return null;
    }
}
