package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class JdbcDao {
    protected Connection getConnection() throws SQLException {
        try {
            Properties props = new Properties();
            InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties");
            props.load(input);
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.username");
            String pass = props.getProperty("db.password");
            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            throw new SQLException("Error al conectar con la base de datos", e);
        }
    }
}
