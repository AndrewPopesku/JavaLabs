package org.example.data;

import org.example.SportCompetition;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SportCompetitionDB {
    private static Connection connection;

    public SportCompetitionDB(DBManager manager) {
        connection = manager.getConnection();
    }

    public void createSportCompetitionTable() {
        String query = "CREATE TABLE IF NOT EXISTS SportCompetition (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name VARCHAR(50) NOT NULL, " +
                "venue VARCHAR(50) NOT NULL, " +
                "date Date)";

        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropSportCompetitionTable() {
        String query = "DROP TABLE IF EXISTS SportCompetition";

        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
