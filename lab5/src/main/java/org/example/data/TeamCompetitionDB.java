package org.example.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TeamCompetitionDB {
    private static Connection connection;

    public TeamCompetitionDB(DBManager manager) {
        connection = manager.getConnection();
    }

    public void createTeamTable() {
        String query = "CREATE TABLE IF NOT EXISTS Team (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name VARCHAR(50) NOT NULL, " +
                "coachName VARCHAR(50) NOT NULL, " +
                "competitionId INTEGER NOT NULL," +
                "FOREIGN KEY(competitionId) REFERENCES SportCompetition(id)" +
                ")";

        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropTeamTable() {
        String query = "DROP TABLE IF EXISTS SportCompetition";

        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
