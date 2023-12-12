package org.example.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager implements AutoCloseable {
    private final String url;
    private Connection connection;

    public DBManager(String url) {
        this.url = url;

        init();
    }

    public Connection getConnection() {
        return connection;
    }

    public void init() {
        try {
            connection = DriverManager.getConnection(url);
            System.out.println("SQLite db is connected successfully!");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}